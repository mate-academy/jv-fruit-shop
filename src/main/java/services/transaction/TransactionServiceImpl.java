package services.transaction;

import java.util.List;
import services.OperationStrategy;
import services.transaction.model.ProductTransaction;

public class TransactionServiceImpl implements TransactionService {
    private final OperationStrategy strategy;

    public TransactionServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<ProductTransaction> productTransactions) {
        productTransactions.forEach(transaction ->
                strategy.get(transaction.getOperation()).handle(transaction));
    }
}
