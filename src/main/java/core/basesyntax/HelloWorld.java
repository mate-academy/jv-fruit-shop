package core.basesyntax;

import core.basesyntax.db.StorageDao;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvWriter;
import core.basesyntax.strategy.impl.TransactionStrategy;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    public static void main(String[] args) {
        ReaderService readerService = new CsvReader();
        StorageDao storageDao = new StorageDao();
        List<String> strings = readerService.readFile("example.csv");
        TransactionStrategy transactionStrategy = new TransactionStrategy(storageDao);
        transactionStrategy.processTransactions(strings);
        WriterService writer = new CsvWriter(storageDao);
        writer.saveFromStorageToFile("sms.file");
    }
}
