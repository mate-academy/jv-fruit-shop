package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.TransactionDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.dao.impl.TransactionDaoImpl;
import core.basesyntax.db.FruitsData;
import core.basesyntax.db.TransactionsData;
import core.basesyntax.model.Fruit;
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
import java.util.stream.Collectors;

/**
 * Feel free to remove this class and create your own.
 */
public class MainApp {
    private static final String journalPath = "src/main/resources/daily_journal.csv";
    private static final String reportPath = "src/main/resources/daily_report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        TransactionDao transactionDao = new TransactionDaoImpl();
        loadTransactions(journalPath);
        TransactionService transactionService = new TransactionServiceImpl(fruitDao, strategyMap());
        for (Transaction transaction : transactionDao.get()) {
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

    private static void loadTransactions(String filePath) {
        TransactionsSupplier supplier = new TransactionsSupplierCsv(filePath);
        TransactionsData.transactions.addAll(supplier.getTransactionsList());
    }

    private static void saveReport(String filePath) {
        FruitsConsumer consumer = new FruitsConsumerCsv(filePath);
        List<Fruit> fruits = FruitsData.fruitMap.entrySet()
                .stream()
                .map(e -> new Fruit(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        consumer.accept(fruits);
    }

}
