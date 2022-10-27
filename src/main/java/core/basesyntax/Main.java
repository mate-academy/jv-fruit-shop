package core.basesyntax;

import core.basesyntax.db.StorageDao;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.StorageLiner;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvWriter;
import core.basesyntax.service.impl.ResultLinerImpl;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.impl.TransactionStrategyImpl;
import core.basesyntax.strategy.transactions.TransactionFunction;
import core.basesyntax.strategy.transactions.TransactionProducer;
import core.basesyntax.strategy.transactions.impl.AdderProducer;
import core.basesyntax.strategy.transactions.impl.ReduceProducer;
import core.basesyntax.strategy.transactions.impl.SaverProducer;
import core.basesyntax.strategy.transactions.impl.TransactionFunctionImpl;
import java.util.HashMap;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        ReaderService readerService = new CsvReader(1);
        StorageDao storageDao = new StorageDao();
        List<String> strings = readerService.readFile("example.csv");
        TransactionFunction transactionFunction = new TransactionFunctionImpl();
        TransactionStrategyImpl transactionStrategyImpl =
                new TransactionStrategyImpl(getTransactionMap(storageDao));
        transactionStrategyImpl
                .distributeTransactions(transactionFunction.apply(strings));
        WriterService writer = new CsvWriter("fruit,quantity");
        StorageLiner storageLiner = new ResultLinerImpl();
        String linesToFile = storageLiner.getLines(storageDao);
        writer.saveFromStorageToFile("sms.file", linesToFile);
    }

    private static HashMap<Operation, TransactionProducer>
            getTransactionMap(StorageDao storageDao) {
        HashMap<Operation, TransactionProducer> transactionMap = new HashMap<>();
        transactionMap.put(Operation.BALANCE, new SaverProducer(storageDao));
        transactionMap.put(Operation.PURCHASE, new ReduceProducer(storageDao));
        transactionMap.put(Operation.SUPPLY, new AdderProducer(storageDao));
        transactionMap.put(Operation.RETURN, new AdderProducer(storageDao));
        return transactionMap;
    }
}
