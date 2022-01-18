package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.db.FruitsData;
import core.basesyntax.model.Transaction;
import core.basesyntax.model.TransactionType;
import core.basesyntax.service.FruitsConsumer;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.TransactionsSupplier;
import core.basesyntax.service.impl.FruitsConsumerCsv;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.TransactionsSupplierCsv;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import core.basesyntax.strategy.TransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class MainApp {
    private static final String journalPath = "src/main/resources/daily_journal.csv";
    private static final String reportPath = "src/main/resources/daily_report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        TransactionService transactionService = new TransactionServiceImpl(fruitDao, strategyMap());
        for (Transaction transaction : loadTransactions(journalPath)) {
            transactionService.apply(transaction);
        }
        saveReport(reportPath);
    }

    private static Map<TransactionType, TransactionHandler> strategyMap() {
        Map<TransactionType, TransactionHandler> mapStrategy = new HashMap<>();
        mapStrategy.put(TransactionType.BALANCE, new BalanceHandler());
        mapStrategy.put(TransactionType.PURCHASE, new PurchaseHandler());
        mapStrategy.put(TransactionType.RETURN, new ReturnHandler());
        mapStrategy.put(TransactionType.SUPPLY, new SupplyHandler());
        return mapStrategy;
    }

    private static List<Transaction> loadTransactions(String filePath) {
        TransactionsSupplier supplier = new TransactionsSupplierCsv(filePath);
        return supplier.getTransactionsList();
    }

    private static void saveReport(String filePath) {
        FruitsConsumer consumer = new FruitsConsumerCsv(filePath);
        consumer.accept(FruitsData.fruitMap);
    }

}
