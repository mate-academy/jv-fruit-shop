package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopFileReader;
import core.basesyntax.service.ShopFileWriter;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopTransaction;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionStrategy;
import core.basesyntax.service.impl.ShopFileReaderCsvImpl;
import core.basesyntax.service.impl.ShopFileWriterCsvImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.ShopTransactionImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.TransactionStrategyImpl;
import core.basesyntax.service.strategy.BalanceHandler;
import core.basesyntax.service.strategy.PurchaseHandler;
import core.basesyntax.service.strategy.ReturnHandler;
import core.basesyntax.service.strategy.SupplyHandler;
import core.basesyntax.service.strategy.TransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_BASE_FILE_NAME = "src/main/resources/database.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, TransactionHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());

        ShopFileReader shopFileReader = new ShopFileReaderCsvImpl();
        ShopFileWriter shopFileWriter = new ShopFileWriterCsvImpl();
        TransactionStrategy transactionStrategy = new TransactionStrategyImpl(activitiesHandlerMap);
        ShopTransaction shopTransaction = new ShopTransactionImpl(transactionStrategy);
        TransactionParser transactionParser = new TransactionParserImpl();
        ShopService shopService = new ShopServiceImpl();

        List<String> dataFromFile = shopFileReader.readFromFile(DATA_BASE_FILE_NAME);
        List<FruitTransaction> fruitTransactions = transactionParser.parse(dataFromFile);
        shopTransaction.makeTransaction(fruitTransactions);
        String report = shopService.makeReport();
        shopFileWriter.writeToFile(REPORT_FILE_NAME, report);
    }
}
