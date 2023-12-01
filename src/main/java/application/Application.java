package application;

import dao.FruitDao;
import dao.FruitDaoImpl;
import dao.ReportDao;
import dao.ReportDaoImpl;
import model.Fruit;
import model.Transaction;
import service.BalanceSetter;
import service.ReportGenerator;
import service.ReportSender;
import service.TransactionProcess;
import service.impl.BalanceSetterImpl;
import service.impl.ReportGenerateImpl;
import service.impl.ReportSenderImpl;
import service.impl.TransactionProcessImpl;
import service.transaction.HandlerTransaction;
import service.transaction.impl.PurchaseProcess;
import service.transaction.impl.ReturnTransaction;
import service.transaction.impl.SupplyTransaction;
import strategy.StrategyTransaction;
import strategy.impl.StrategyTransactionImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String TRANSACTION_FILE_NAME_PATH
            = "src/main/java/resources/transactions.csv";
    private static final String REPORT_FILE_NAME_PATH
            = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        Map<Transaction, HandlerTransaction> transactionHandlerTransactionMap
                = new HashMap<>();
        transactionHandlerTransactionMap.put(Transaction.SUPPLY, new SupplyTransaction());
        transactionHandlerTransactionMap.put(Transaction.PURCHASE, new PurchaseProcess());
        transactionHandlerTransactionMap.put(Transaction.RETURN, new ReturnTransaction());

        StrategyTransaction strategyTransaction
                = new StrategyTransactionImpl(transactionHandlerTransactionMap);
        ReportDao reportDao = new ReportDaoImpl();
        FruitDao fruitDao = new FruitDaoImpl(TRANSACTION_FILE_NAME_PATH, reportDao);

        BalanceSetter balanceSetter = new BalanceSetterImpl(reportDao);
        TransactionProcess transactionProcess
                = new TransactionProcessImpl(strategyTransaction, reportDao);
        ReportGenerator reportGenerator = new ReportGenerateImpl(reportDao);
        ReportSender reportSender = new ReportSenderImpl(REPORT_FILE_NAME_PATH);

        List<Fruit> fruitList = fruitDao.getFruit();

        balanceSetter.setBalance(fruitList);
        fruitList.forEach(transactionProcess::processPerform);

        String report = reportGenerator.generateReport();
        reportSender.sendReport(report);
    }
}
