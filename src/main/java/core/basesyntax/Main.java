package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ConverterService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.ConverterTransactionServiceImpl;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.transaction.BalanceTransactionHandler;
import core.basesyntax.service.transaction.PurchaseTransactionHandler;
import core.basesyntax.service.transaction.ReturnTransactionHandler;
import core.basesyntax.service.transaction.SupplyTransactionHandler;
import core.basesyntax.service.transaction.TransactionHandler;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.TransactionStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FILE_PATH = "src/main/resources/transaction.csv";
    private static final String WRITE_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReaderService readerService = new CsvFileReaderServiceImpl();
        List<String> readFromFile = readerService
                .readFromFile(READ_FILE_PATH);

        ConverterService converterService = new ConverterTransactionServiceImpl();
        List<Transaction> transactions = converterService.convertFromString(readFromFile);

        StorageDao storageDao = new StorageDaoImpl();
        TransactionStrategy transactionStrategy =
                new TransactionStrategyImpl(initHandlerMap(storageDao));
        transactionStrategy.processTransactions(transactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport(storageDao.getFruitsFromStorage());

        FileWriterService writerService = new CsvFileWriterServiceImpl();
        writerService.writeToFile(report, WRITE_FILE_PATH);
    }

    private static Map<Operation, TransactionHandler> initHandlerMap(StorageDao storageDao) {
        TransactionHandler balanceTransactionHandler = new BalanceTransactionHandler(storageDao);
        TransactionHandler purchaseTransactionHandler = new PurchaseTransactionHandler(storageDao);
        TransactionHandler returnTransactionHandler = new ReturnTransactionHandler(storageDao);
        TransactionHandler supplyTransactionHandler = new SupplyTransactionHandler(storageDao);

        Map<Operation, TransactionHandler> handlerMap = new HashMap<>();
        handlerMap.put(Operation.BALANCE, balanceTransactionHandler);
        handlerMap.put(Operation.PURCHASE, purchaseTransactionHandler);
        handlerMap.put(Operation.RETURN, returnTransactionHandler);
        handlerMap.put(Operation.SUPPLY, supplyTransactionHandler);
        return handlerMap;
    }
}
