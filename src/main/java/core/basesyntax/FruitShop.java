package core.basesyntax;

import core.basesyntax.dao.FruitReportDao;
import core.basesyntax.dao.FruitReportDaoImpl;
import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.dbtransaction.FruitTransactionsStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.TransactionService;
import core.basesyntax.services.TransactionServiceImpl;
import core.basesyntax.services.TransactionStrategy;
import core.basesyntax.services.TransactionStrategyImpl;
import core.basesyntax.services.transaction.BalanceTransaction;
import core.basesyntax.services.transaction.PurchaseTransaction;
import core.basesyntax.services.transaction.ReturnTransaction;
import core.basesyntax.services.transaction.SupplyTransaction;
import core.basesyntax.services.transaction.Transaction;
import java.util.HashMap;
import java.util.Map;

public class FruitShop {
    private static final String FRUIT_TRANSACTION_FILE_NAME = "src/main/resources/transactions.csv";
    private static final String FRUIT_REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, Transaction> transactionMap = new HashMap<>();
        transactionMap.put(FruitTransaction.Operation.BALANCE, new BalanceTransaction());
        transactionMap.put(FruitTransaction.Operation.SUPPLY, new SupplyTransaction());
        transactionMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseTransaction());
        transactionMap.put(FruitTransaction.Operation.RETURN, new ReturnTransaction());

        FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
        fruitTransactionDao.get(FRUIT_TRANSACTION_FILE_NAME);

        TransactionStrategy transactionStrategy = new TransactionStrategyImpl(transactionMap);
        TransactionService transactionService = new TransactionServiceImpl(transactionStrategy);

        for (FruitTransaction transaction: FruitTransactionsStorage.fruitTransactions) {
            transactionService.doTransaction(transaction);
        }

        FruitReportDao fruitReportDao = new FruitReportDaoImpl();
        fruitReportDao.put(FRUIT_REPORT_FILE_NAME);
    }
}
