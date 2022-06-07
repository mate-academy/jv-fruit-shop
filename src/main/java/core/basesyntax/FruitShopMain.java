package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandlerStrategy;
import core.basesyntax.service.OperationProcessor;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.OperationHandlerStrategyImpl;
import core.basesyntax.service.impl.OperationProcessorImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopMain {
    private static final String FROM_FILE = "src/main/resources/dailyOperations.csv";
    private static final String TO_FILE = "src/main/resources/dailyReport.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> strategyMap =
                new HashMap<>();
        strategyMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(storageDao));
        strategyMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(storageDao));
        strategyMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(storageDao));
        strategyMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler(storageDao));
        OperationHandlerStrategy operationHandlerStrategy =
                new OperationHandlerStrategyImpl(strategyMap);

        Reader reader = new ReaderImpl();
        List<String> dailyOperationsList = reader.readFromFile(FROM_FILE);

        Parser parser = new ParserImpl();
        List<FruitTransaction> fruitTransactions =
                parser.parseData(dailyOperationsList);

        OperationProcessor operationProcessor =
                new OperationProcessorImpl(operationHandlerStrategy);
        operationProcessor.processData(fruitTransactions);

        ReportCreator reportCreator = new ReportCreatorImpl(storageDao);
        String report = reportCreator.createReport();

        Writer writer = new WriterImpl();
        writer.writeToFile(report, TO_FILE);
    }
}
