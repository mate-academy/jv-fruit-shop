package core.basesyntax.service.factory;

import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;

public class ServiceFactory {
    private static FruitTransactionService transactionService;
    private static WriterService writerService;
    private static ReaderService readerService;

    public static FruitTransactionService createFruitTransactionService() {
        if (transactionService == null) {
            transactionService = new FruitTransactionServiceImpl(new FruitTransactionDaoImpl());
        }

        return transactionService;
    }

    public static WriterService createWriterService() {
        if (writerService == null) {
            writerService = new WriterServiceImpl();
        }

        return writerService;
    }

    public static ReaderService createReaderService() {
        if (readerService == null) {
            readerService = new ReaderServiceImpl(new FruitTransactionDaoImpl());
        }

        return readerService;
    }
}
