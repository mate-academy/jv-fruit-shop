package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.TransactionsHandling;
import core.basesyntax.strategy.impl.BalanceHandlingImpl;
import core.basesyntax.strategy.impl.PurchaseHandlingImpl;
import core.basesyntax.strategy.impl.ReturnHandlingImpl;
import core.basesyntax.strategy.impl.SupplyHandlingImpl;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopMain {
    private static final String FROM_FILE = "src/main/resources/daily_transaction.csv";
    private static final String TO_FILE = "src/main/resources/daily_report.csv";

    public static void main(String[] args) {
        //Creation of instances of objects dao, map strategy, operation processing services
        StorageDao storageDao = new StorageDaoImpl();
        Map<Transaction.Operation, TransactionsHandling> strategy =
                new HashMap<>();
        strategy.put(Transaction.Operation.BALANCE, new BalanceHandlingImpl(storageDao));
        strategy.put(Transaction.Operation.SUPPLY, new SupplyHandlingImpl(storageDao));
        strategy.put(Transaction.Operation.PURCHASE, new PurchaseHandlingImpl(storageDao));
        strategy.put(Transaction.Operation.RETURN, new ReturnHandlingImpl(storageDao));
        OperationProcessingStrategy operationProcessingStrategy =
                new OperationProcessingStrategyImpl(strategy);
        //Import data
        ImportDataService reader = new ImportDataServiceImpl();
        List<String> dailyTransactionList = reader.ReaderFromCsvFile(FROM_FILE);
        //Parse data
        ParseService parserService = new ParseServiceImpl();
        List<Transaction> transactionList = parserService.parser(dailyTransactionList);
        //Operation processing
        OperationProcessing operationProcessing =
                new OperationProcessingImpl(operationProcessingStrategy);
        operationProcessing.processingData(transactionList);
        //Create report
        ReportService reportService = new ReportServiceImpl(storageDao);
        String report = reportService.report();
        //Export data
        ExportDataService writer = new ExportDataServiceImpl();
        writer.writeToCsvFile(report, TO_FILE);
    }
}
