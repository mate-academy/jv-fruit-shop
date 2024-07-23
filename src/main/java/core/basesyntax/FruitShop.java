package core.basesyntax;

import core.basesyntax.dao.ReportDao;
import core.basesyntax.dao.impl.ReportDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.GenerateReport;
import core.basesyntax.service.Reader;
import core.basesyntax.service.SenderReport;
import core.basesyntax.service.SetterBalance;
import core.basesyntax.service.TransactionProcess;
import core.basesyntax.service.impl.GenerateReportImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.SenderReportImpl;
import core.basesyntax.service.impl.SetterBalanceImpl;
import core.basesyntax.service.impl.TransactionProcessImpl;
import core.basesyntax.strategy.StrategyFruitTransaction;
import core.basesyntax.strategy.impl.StrategyFruitTransactionImpl;
import core.basesyntax.transaction.HandlerOperation;
import core.basesyntax.transaction.impl.Purchase;
import core.basesyntax.transaction.impl.Return;
import core.basesyntax.transaction.impl.Supply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private static final String TRANSACTIONS_FILE_PATH
            = "src/main/java/core/basesyntax/resourses/transactions.csv";
    private static final String REPORTS_FILE_PATH
            = "src/main/java/core/basesyntax/resourses/reports.csv";
    private static final Map<Operation, HandlerOperation> operations = new HashMap<>();

    static {
        operations.put(Operation.SUPPLY, new Supply());
        operations.put(Operation.PURCHASE, new Purchase());
        operations.put(Operation.RETURN, new Return());
    }

    public static void main(String[] args) {
        StrategyFruitTransaction strategyFruitTransaction
                = new StrategyFruitTransactionImpl(operations);
        ReportDao reportDao = new ReportDaoImpl();
        Reader reader = new ReaderImpl();
        SetterBalance setterBalance = new SetterBalanceImpl(reportDao);
        TransactionProcess transactionProcess
                = new TransactionProcessImpl(strategyFruitTransaction, reportDao);
        GenerateReport generateReport = new GenerateReportImpl(reportDao);
        SenderReport senderReport = new SenderReportImpl();
        List<FruitTransaction> fruitTransactions = reader.read(TRANSACTIONS_FILE_PATH);
        setterBalance.setBalance(fruitTransactions);
        fruitTransactions.forEach(transactionProcess::process);
        String report = generateReport.generate();
        senderReport.send(REPORTS_FILE_PATH, report);
    }
}
