package service.transaction;

import dao.DbDao;
import java.util.List;
import java.util.Map;
import model.Transaction;
import service.transaction.strategy.TransactionStrategy;

public class ProductTransactionExecutor implements TransactionExecutor {
    private TransactionStrategy transactionStrategy;
    private DbDao dbDao;

    public ProductTransactionExecutor(TransactionStrategy transactionStrategy, DbDao dbDao) {
        this.transactionStrategy = transactionStrategy;
        this.dbDao = dbDao;
    }

    @Override
    public void execute(List<Transaction> transactions) {
        Map<String, Integer> data = dbDao.getData();
        transactions.stream()
                .forEach(t -> transactionStrategy.getHandler(t.getType()).perform(data, t));
        dbDao.updateData(data);
    }
}
