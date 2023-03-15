package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvParser;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvParserImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import core.basesyntax.strategy.impl.TransactionStrategyImpl;
import java.util.List;
import java.util.Map;

public class MainApplication {
    private static final String INPUT_FILE = "src/main/resources/database.csv";
    private static final String OUTPUT_FILE = "src/main/resources/report.csv";
    private static Map<TransactionDto.Operation, OperationHandler> operationsMap;

    private static void initializeMap() {
        operationsMap = Map.of(
                TransactionDto.Operation.RETURN, new ReturnOperationHandler(),
                TransactionDto.Operation.BALANCE, new BalanceOperationHandler(),
                TransactionDto.Operation.PURCHASE, new PurchaseOperationHandler(),
                TransactionDto.Operation.SUPPLY, new SupplyOperationHandler());
    }

    public static void main(String[] args) {
        initializeMap();
        FruitDao fruitDao = new FruitDaoImpl();
        TransactionStrategy strategy = new TransactionStrategyImpl(operationsMap);
        FruitService fruitService = new FruitServiceImpl(fruitDao, strategy);
        ReaderService reader = new ReaderServiceImpl();
        List<String> rowTransactions = reader.read(INPUT_FILE);
        CsvParser parser = new CsvParserImpl();
        fruitService.updateAll(parser.parse(rowTransactions));
        WriterService reportWriter = new WriterServiceImpl();
        reportWriter.write(OUTPUT_FILE);
    }
}
