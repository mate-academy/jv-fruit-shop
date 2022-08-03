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
        FileReader readFile = new ReadFileImpl();
        List<String> data = readFile.readFromFile(WAY_TO_INPUT);
        ParserService parseService = new ParserServiceImpl();
        List<FruitTransaction> transactions = parseService.parse(data);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        TransactionProcessor transaction = new TransactionImpl(operationStrategy);
        transaction.process(transactions);
        ReportCreator editor = new ReportCreatorImpl(storageDao);
        String report = editor.create();
        FileWriter writeToFile = new FileWriterImpl();
        writeToFile.writeToFile(WAY_TO_REPORT, report);
    }
}
