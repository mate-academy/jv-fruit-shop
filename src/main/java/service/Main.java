package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.dao.ParserReader;
import service.dao.ParserReaderImpl;
import service.dao.ParserWriter;
import service.dao.ParserWriterImpl;
import service.dao.Reader;
import service.dao.ReaderImpl;
import service.dao.Writer;
import service.dao.WriterImpl;
import service.storage.Balance;
import service.storage.PerformingOperation;
import service.storage.Purchase;
import service.storage.Return;
import service.storage.Supply;

public class Main {

    public static void main(String[] args) {
        // Read data from file
        Reader fileDao = new ReaderImpl();
        List<String> listFromFile = fileDao.readFromFileToList();
        // Convert data to Java object
        ParserReader parser = new ParserReaderImpl();
        List<FruitTransaction> fruitTransactions = parser
                .parsedToFruitTransaction(listFromFile);
        // Data operation Strategy
        HashMap<FruitTransaction.Operation, PerformingOperation> operationHashMap = new HashMap<>();
        operationHashMap.put(FruitTransaction.Operation.BALANCE, new Balance());
        operationHashMap.put(FruitTransaction.Operation.PURCHASE, new Purchase());
        operationHashMap.put(FruitTransaction.Operation.RETURN, new Return());
        operationHashMap.put(FruitTransaction.Operation.SUPPLY, new Supply());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHashMap);
        // Data processing
        ShopServiceImpl shopService = new ShopServiceImpl(operationStrategy);
        Map<String,Integer> mapReport = shopService.getRepport(fruitTransactions);
        // Create report
        ParserWriter parserTo = new ParserWriterImpl();
        List<String> report = parserTo.parsedListToFile(mapReport);
        // Write report to file
        Writer writeFile = new WriterImpl();
        writeFile.writeListToFile(report);
    }
}
