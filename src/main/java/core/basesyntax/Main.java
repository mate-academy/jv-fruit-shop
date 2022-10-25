package core.basesyntax;

import core.basesyntax.db.StorageDao;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvWriter;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.impl.TransactionStrategy;
import core.basesyntax.strategy.transactions.TransactionProducer;
import core.basesyntax.strategy.transactions.impl.AdderProducer;
import core.basesyntax.strategy.transactions.impl.ReduceProducer;
import core.basesyntax.strategy.transactions.impl.SaverProducer;
import java.util.HashMap;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        ReaderService readerService = new CsvReader();
        StorageDao storageDao = new StorageDao();
        List<String> strings = readerService.readFile("example.csv");
        TransactionStrategy transactionStrategy = new TransactionStrategy(storageDao,
                getTransactionMap());
        transactionStrategy.processTransactions(strings);
        WriterService writer = new CsvWriter(storageDao);
        writer.saveFromStorageToFile("sms.file");
    }

    private static HashMap<Operation, TransactionProducer> getTransactionMap() {
        HashMap<Operation, TransactionProducer> transactionMap = new HashMap<>();
        transactionMap.put(Operation.BALANCE, new SaverProducer());
        transactionMap.put(Operation.PURCHASE, new ReduceProducer());
        transactionMap.put(Operation.SUPPLY, new AdderProducer());
        transactionMap.put(Operation.RETURN, new AdderProducer());
        return transactionMap;
    }
}
