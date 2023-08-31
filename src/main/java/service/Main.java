package service;

import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.HashMap;
import java.util.List;
import model.FruitTransaction;
import service.operation.BalanceHandler;
import service.operation.OperationHandler;
import service.operation.PurchaseHandler;
import service.operation.ReturnHandler;
import service.operation.SupplyHandler;
import service.util.ParserReader;
import service.util.ParserReaderImpl;
import service.util.ParserWriter;
import service.util.ParserWriterImpl;
import service.util.Reader;
import service.util.ReaderImpl;
import service.util.Writer;
import service.util.WriterImpl;

public class Main {

    public static void main(String[] args) {
        // Read data from file
        Reader fileDao = new ReaderImpl();
        List<String> listFromFile = fileDao.readFromFileToList();
        // Convert data to Java object
        ParserReader parser = new ParserReaderImpl();
        final List<FruitTransaction> fruitTransactions = parser
                .parsedToFruitTransaction(listFromFile);
        // Data operation Strategy
        StorageDao storageDao = new StorageDaoImpl();
        HashMap<FruitTransaction.Operation, OperationHandler> operationHashMap = new HashMap<>();
        operationHashMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(storageDao));
        operationHashMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(storageDao));
        operationHashMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler(storageDao));
        operationHashMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(storageDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHashMap);
        // Data processing
        ShopServiceImpl shopService = new ShopServiceImpl(operationStrategy);
        shopService.processTransactions(fruitTransactions);
        // Create report
        ParserWriter parserTo = new ParserWriterImpl(storageDao);
        List<String> report = parserTo.parsedListToFile();
        // Write report to file
        Writer writeFile = new WriterImpl();
        writeFile.writeListToFile(report);
    }
}
