package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitShopTransactions;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitParser;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitParserImpl;
import core.basesyntax.service.impl.OperationServiceImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/inputFile.csv";
    private static final String REPORT_FILE = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitShopTransactions.Operation, OperationHandler> strategyMap = new HashMap<>();
        strategyMap.put(FruitShopTransactions.Operation.BALANCE, new BalanceHandler(storageDao));
        strategyMap.put(FruitShopTransactions.Operation.SUPPLY, new SupplyHandler(storageDao));
        strategyMap.put(FruitShopTransactions.Operation.PURCHASE, new PurchaseHandler(storageDao));
        strategyMap.put(FruitShopTransactions.Operation.RETURN, new ReturnHandler(storageDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategyMap);
        FileReader reader = new FileReaderImpl();
        List<String> input = reader.readFromFile(Paths.get(INPUT_FILE));
        FruitParser parser = new FruitParserImpl();
        List<FruitShopTransactions> fruitShopTransactions = parser.parse(input);
        OperationService operationService = new OperationServiceImpl(operationStrategy);
        operationService.processData(fruitShopTransactions);
        ReportCreator reportCreator = new ReportCreatorImpl(storageDao);
        String report = reportCreator.createReport();
        FileWriter writer = new FileWriterImpl();
        writer.writerDataToFile(report, REPORT_FILE);
    }
}
