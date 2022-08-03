package core.basesyntax;

import dao.StorageDao;
import dao.StorageDaoImpl;
import db.Storage;
import handler.BalanceOperationHandler;
import handler.OperationHandler;
import handler.PurchaseOperationHandler;
import handler.ReturnOperationHandler;
import handler.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReader;
import service.FileWriter;
import service.ParserService;
import service.ReportCreator;
import service.TransactionProcessor;
import serviceimpl.FileWriterImpl;
import serviceimpl.ParserServiceImpl;
import serviceimpl.ReadFileImpl;
import serviceimpl.ReportCreatorImpl;
import serviceimpl.TransactionImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String WAY_TO_INPUT = "src/main/resources/StartDay.csv";
    private static final String WAY_TO_REPORT = "src/main/resources/CloseDay.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl(new Storage());
        Map<FruitTransaction.Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(storageDao));
        operationMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(storageDao));
        operationMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(storageDao));
        operationMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(storageDao));
        FileReader fileReader = new ReadFileImpl();
        List<String> data = fileReader.readFromFile(WAY_TO_INPUT);
        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> transactions = parserService.parse(data);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        TransactionProcessor transactionProcessor = new TransactionImpl(operationStrategy);
        transactionProcessor.process(transactions);
        ReportCreator reportCreator = new ReportCreatorImpl(storageDao);
        String report = reportCreator.create();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(WAY_TO_REPORT, report);
    }
}
