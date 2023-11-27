package main;

import main.dao.ReportDao;
import main.dao.ReportDaoImpl;
import main.dao.ProductDao;
import main.dao.ProductDaoCsvImpl;
import main.model.Product;
import main.model.Transaction;
import main.service.BalanceSetter;
import main.service.impl.BalanceSetterImpl;
import main.service.impl.ReportGeneratorCsvImpl;
import main.service.impl.ReportSenderCsvImpl;
import main.service.impl.TransactionProcessingImpl;
import main.service.transaction.Impl.PurchaseTransactionHandler;
import main.service.transaction.Impl.ReturnTransactionHandler;
import main.service.transaction.Impl.SupplyTransactionHandler;
import main.service.transaction.TransactionHandler;
import main.service.ReportGenerator;
import main.service.ReportSender;
import main.service.TransactionProcessing;
import main.strategy.impl.TransactionStrategyImpl;
import main.strategy.TransactionStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String TRANSACTIONS_CSV_FILE_NAME = "src/main/resources/transactions.csv";
    public static final String REPORT_CSV_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Transaction, TransactionHandler> transactionHandlerMap = new HashMap<>();
        transactionHandlerMap.put(Transaction.SUPPLY, new SupplyTransactionHandler());
        transactionHandlerMap.put(Transaction.PURCHASE, new PurchaseTransactionHandler());
        transactionHandlerMap.put(Transaction.RETURN, new ReturnTransactionHandler());

        TransactionStrategy transactionStrategy = new TransactionStrategyImpl(transactionHandlerMap);
        ReportDao reportDao = new ReportDaoImpl();
        ProductDao productDao = new ProductDaoCsvImpl(TRANSACTIONS_CSV_FILE_NAME, reportDao);

        BalanceSetter balanceSetter = new BalanceSetterImpl(reportDao);
        TransactionProcessing transactionProcessing = new TransactionProcessingImpl(transactionStrategy, reportDao);
        ReportGenerator reportGenerator = new ReportGeneratorCsvImpl(reportDao);
        ReportSender reportSender = new ReportSenderCsvImpl(REPORT_CSV_FILE_PATH);

        List<Product> products = productDao.get();

        balanceSetter.setBalance(products);
        products.forEach(transactionProcessing::perform);

        String report = reportGenerator.create();
        reportSender.send(report);
    }
}
