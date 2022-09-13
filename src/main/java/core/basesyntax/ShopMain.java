package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationProcessingStrategy;
import core.basesyntax.service.OperationProcessor;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParseService;
import core.basesyntax.service.impl.CsvReportServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.OperationProcessingServiceImpl;
import core.basesyntax.service.impl.OperationProcessingStrategyImpl;
import core.basesyntax.service.impl.TransactionParseServiceImpl;
import core.basesyntax.strategy.TransactionsHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandlerImpl;
import core.basesyntax.strategy.impl.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.impl.SupplyOperationHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopMain {
    private static final String FROM_FILE = "src/main/resources/daily_transactions.csv";
    private static final String TO_FILE = "src/main/resources/daily_report.csv";

    public static void main(String[] args) {
        //Creation of instances of objects dao, map strategy, operation processing services
        StorageDao storageDao = new StorageDaoImpl();
        Map<Transaction.Operation, TransactionsHandler> strategy =
                new HashMap<>();
        strategy.put(Transaction.Operation.BALANCE, new BalanceOperationHandlerImpl(storageDao));
        strategy.put(Transaction.Operation.SUPPLY, new SupplyOperationHandlerImpl(storageDao));
        strategy.put(Transaction.Operation.PURCHASE, new PurchaseOperationHandlerImpl(storageDao));
        strategy.put(Transaction.Operation.RETURN, new ReturnOperationHandlerImpl(storageDao));
        OperationProcessingStrategy operationProcessingStrategy =
                new OperationProcessingStrategyImpl(strategy);
        //Import data
        FileReaderService reader = new FileReaderServiceImpl();
        List<String> dailyTransactionList = reader.read(FROM_FILE);
        //Parse data
        TransactionParseService parserService = new TransactionParseServiceImpl();
        List<Transaction> transactionList = parserService.parser(dailyTransactionList);
        //Operation processing
        OperationProcessor operationProcessor =
                new OperationProcessingServiceImpl(operationProcessingStrategy);
        operationProcessor.process(transactionList);
        //Create report
        ReportService reportService = new CsvReportServiceImpl(storageDao);
        String report = reportService.createReport();
        //Export data
        FileWriterService writer = new FileWriterServiceImpl();
        writer.write(report, TO_FILE);
    }
}
