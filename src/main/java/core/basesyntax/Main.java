package core.basesyntax;

import core.basesyntax.db.StorageDao;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvWriter;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.impl.TransactionServiceImpl;
import core.basesyntax.strategy.transactions.FruitTransactionParser;
import core.basesyntax.strategy.transactions.TransactionHandler;
import core.basesyntax.strategy.transactions.impl.AdderHandler;
import core.basesyntax.strategy.transactions.impl.ReduceHandler;
import core.basesyntax.strategy.transactions.impl.SaverHandler;
import java.util.HashMap;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static final int numberOfTitleInCsv = 1;
    public static final String exampleFile = "example.csv";
    public static final String titleForCsv = "fruit,quantity";
    public static final String resultTargetFile = "sms.csv";

    public static void main(String[] args) {
        ReaderService readerService = new CsvReader();
        StorageDao storageDao = new StorageDao();
        List<String> strings = readerService.readFile(exampleFile, numberOfTitleInCsv);
        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
        TransactionService transactionService =
                new TransactionServiceImpl(getTransactionMap(storageDao));
        transactionService
                .applyTransactions(fruitTransactionParser.parse(strings));
        WriterService writer = new CsvWriter(titleForCsv);
        ReportService reportService = new ReportServiceImpl();
        String linesToFile = reportService.createReport(storageDao);
        writer.saveToFile(resultTargetFile, linesToFile);
    }

    private static HashMap<Operation, TransactionHandler>
            getTransactionMap(StorageDao storageDao) {
        HashMap<Operation, TransactionHandler> transactionMap = new HashMap<>();
        transactionMap.put(Operation.BALANCE, new SaverHandler(storageDao));
        transactionMap.put(Operation.PURCHASE, new ReduceHandler(storageDao));
        transactionMap.put(Operation.SUPPLY, new AdderHandler(storageDao));
        transactionMap.put(Operation.RETURN, new AdderHandler(storageDao));
        return transactionMap;
    }
}
