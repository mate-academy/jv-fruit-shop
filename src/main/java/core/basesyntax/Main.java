package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Report;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.service.CsvReader;
import core.basesyntax.service.Mapper;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.CsvReaderImpl;
import core.basesyntax.service.impl.FruitTransactionMapper;
import core.basesyntax.service.impl.ReportMapper;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.*;

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
        System.out.println("TRANSACTIONS:");
        transactions.forEach(System.out::println);
        System.out.println("=============");

        Map<Operation, OperationHandler> strategiesMap = new HashMap<>();

        strategiesMap.put(Operation.BALANCE, new BalanceOperationHandler());
        strategiesMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        strategiesMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        strategiesMap.put(Operation.RETURN, new ReturnOperationHandler());

        OperationStrategy strategy = new OperationStrategyImpl(strategiesMap);
        ShopService service = new ShopServiceImpl(strategy);
        Report report = service.process(transactions);
        report.getFruitQuantityMap().forEach((s, i) -> System.out.println(s + " ==> " + i));

        Mapper<String, Report> reportMapper = new ReportMapper();
        String reportString = reportMapper.toObject(report);
        // Write report to new CSV file
    }
}
