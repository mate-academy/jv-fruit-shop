package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageDao;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvWriter;
import core.basesyntax.service.impl.TransactionService;
import core.basesyntax.service.impl.CsvReader;

import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    public static void main(String[] args) {
        ReaderService readerService = new CsvReader();
        List<String> strings = readerService.readFile("example.csv");
        System.out.println(strings);
        TransactionService transactionService = new TransactionService(new StorageDao());
        transactionService.processTransactions(strings);
        System.out.println(Storage.fruitStorage);
        WriterService writer = new CsvWriter(new StorageDao());
        writer.saveFromStorageToFile("sms.file");
    }
}
