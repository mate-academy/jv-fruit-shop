package service.transaction;

import dao.Dao;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.transaction.strategy.TransactionStrategy;

public class ProductTransactionExecutor implements TransactionExecutor {
    private TransactionStrategy transactionStrategy;
    private Dao dao;

    public ProductTransactionExecutor(TransactionStrategy transactionStrategy, Dao dao) {
        this.transactionStrategy = transactionStrategy;
        this.dao = dao;
    }

    @Override
    public void execute(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> data = dao.getStock();
        fruitTransactions.stream()
                .forEach(t -> transactionStrategy.getHandler(t.getType()).perform(data, t));
        dao.updateStock(data);
    }
}
