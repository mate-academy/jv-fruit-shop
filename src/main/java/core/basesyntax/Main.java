package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ConverterService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.ConverterTransactionServiceImp;
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
    public static void main(String[] args) {
        FileReaderService readerService = new CsvFileReaderServiceImpl();
        List<String> readFromFile = readerService
                .readFromFile("src/main/resources/transaction.csv");

        ConverterService converterService = new ConverterTransactionServiceImp();
        List<Transaction> transactions = converterService.convertFromString(readFromFile);

        StorageDao storageDao = new StorageDaoImpl();
        TransactionStrategy transactionStrategy =
                new TransactionStrategyImpl(initHandlerMap(storageDao));
        transactionStrategy.processTransaction(transactions);

        ReportService reportService = new ReportServiceImpl();
        String infoForReport = reportService.getInfoForReport(storageDao.getMapHandler());
        String report = reportService.getReportFruitStorage(infoForReport);

        FileWriterService writerService = new CsvFileWriterServiceImpl();
        writerService.writeToFile(report, "src/main/resources/report.csv");
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
