package core.basesyntax;

import static core.basesyntax.model.FruitTransaction.Operation.BALANCE;
import static core.basesyntax.model.FruitTransaction.Operation.PURCHASE;
import static core.basesyntax.model.FruitTransaction.Operation.RETURN;
import static core.basesyntax.model.FruitTransaction.Operation.SUPPLY;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.hadler.OperationHandler;
import core.basesyntax.hadler.impl.BalanceOperationHandler;
import core.basesyntax.hadler.impl.DecreaseOperationHandler;
import core.basesyntax.hadler.impl.IncreaseOperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitShopService;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFile = "transactions.csv";
        FileReader fileReader = new FileReaderImpl();
        List<String> inputData = fileReader.readFile(inputFile);
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(BALANCE, new BalanceOperationHandler(storageDao));
        handlerMap.put(SUPPLY, new DecreaseOperationHandler(storageDao));
        OperationHandler increaseOperationHandler = new IncreaseOperationHandler(storageDao);
        handlerMap.put(PURCHASE, increaseOperationHandler);
        handlerMap.put(RETURN, increaseOperationHandler);
        OperationStrategy strategy = new OperationStrategyImpl(handlerMap);
        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> transactions = transactionParser.parse(inputData);
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = strategy.get(transaction.getOperation());
            handler.handle(transaction);
        }
        ShopService shopService = new FruitShopService(storageDao);
        Map<String, Integer> balance = shopService.getBalance();
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(balance);
        FileWriter fileWriter = new FileWriterImpl();
        String toFile = "report.csv";
        fileWriter.writeReport(toFile, report);
    }
}
