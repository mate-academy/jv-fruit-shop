package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Report;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.service.CsvReader;
import core.basesyntax.service.CsvWriter;
import core.basesyntax.service.Mapper;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.CsvReaderImpl;
import core.basesyntax.service.impl.CsvWriterImpl;
import core.basesyntax.service.impl.FruitTransactionMapper;
import core.basesyntax.service.impl.ReportMapper;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.QuantityIncrementer;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.QuantityIncrementerImpl;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import core.basesyntax.strategy.validator.MapValidator;
import core.basesyntax.strategy.validator.impl.KeyAbsentValidator;
import core.basesyntax.strategy.validator.impl.KeyPresentValidator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CsvReader reader = new CsvReaderImpl();
        List<String> strings = reader.readLines("src/main/resources/fruits.csv");

        Mapper<FruitTransaction, String> mapper = new FruitTransactionMapper();
        List<FruitTransaction> transactions = strings.stream()
                .map(mapper::toObject)
                .toList();

        MapValidator keyPresentValidator = new KeyPresentValidator();
        MapValidator keyAbsentValidator = new KeyAbsentValidator();
        QuantityIncrementer incrementer = new QuantityIncrementerImpl();

        Map<Operation, OperationHandler> strategiesMap = new HashMap<>();
        strategiesMap.put(Operation.BALANCE,
                new BalanceOperationHandler(keyAbsentValidator));
        strategiesMap.put(Operation.SUPPLY,
                new SupplyOperationHandler(keyPresentValidator, incrementer));
        strategiesMap.put(Operation.PURCHASE,
                new PurchaseOperationHandler(keyPresentValidator));
        strategiesMap.put(Operation.RETURN,
                new ReturnOperationHandler(keyPresentValidator, incrementer));

        OperationStrategy strategy = new OperationStrategyImpl(strategiesMap);
        ShopService service = new ShopServiceImpl(strategy);
        Report report = service.process(transactions);

        Mapper<String, Report> reportMapper = new ReportMapper();
        String reportString = reportMapper.toObject(report);

        CsvWriter writer = new CsvWriterImpl();
        writer.write("src/main/resources/fruits_report.csv", reportString);
    }
}
