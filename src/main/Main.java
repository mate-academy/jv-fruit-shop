package main;

import main.dao.ReportDao;
import main.dao.ReportDaoImpl;
import main.dao.TransactionsDao;
import main.dao.TransactionsDaoCsvImpl;
import main.model.ProductTransaction;
import main.service.Impl.ReportGeneratorCsvImpl;
import main.service.Impl.ReportSenderCsvImpl;
import main.service.Impl.TransactionProcessingImpl;
import main.service.Operation.Impl.BalanceOperationHandler;
import main.service.Operation.Impl.PurchaseOperationHandler;
import main.service.Operation.Impl.ReturnOperationHandler;
import main.service.Operation.Impl.SupplyOperationHandler;
import main.service.Operation.OperationHandler;
import main.service.ReportGenerator;
import main.service.ReportSender;
import main.service.TransactionProcessing;
import main.strategy.Impl.OperationStrategyImpl;
import main.strategy.OperationStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String TRANSACTIONS_CSV_FILE_NAME = "src/main/resources/transactions.csv";
    public static final String REPORT_CSV_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<ProductTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(ProductTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(ProductTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(ProductTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(ProductTransaction.Operation.RETURN, new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReportDao reportDao = new ReportDaoImpl();
        TransactionsDao transactionsDao = new TransactionsDaoCsvImpl(TRANSACTIONS_CSV_FILE_NAME);

        TransactionProcessing transactionProcessing = new TransactionProcessingImpl(operationStrategy, reportDao);
        ReportGenerator reportGenerator = new ReportGeneratorCsvImpl(reportDao);
        ReportSender reportSender = new ReportSenderCsvImpl(REPORT_CSV_FILE_PATH);

        Map<String, List<ProductTransaction>> transactionsPerDay = transactionsDao.get();
        transactionProcessing.perform(transactionsPerDay);
        String report = reportGenerator.create();
        reportSender.send(report);
    }
}
