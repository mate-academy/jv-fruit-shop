package service.transaction;

import java.util.List;
import model.Transaction;
import service.transaction.strategy.TransactionStrategy;

public class ProductTransactionExecutor implements TransactionExecutor {
    private TransactionStrategy transactionStrategy;

    public ProductTransactionExecutor(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public void execute(List<Transaction> transactions) {
        transactions.stream()
                .forEach(x -> transactionStrategy.getHandler(x.getType()).perform(x));
    }
}
