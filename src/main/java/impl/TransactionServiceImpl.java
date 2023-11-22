package impl;

import impl.operation.OperationStrategy;
import java.util.List;
import model.FruitTransaction;
import service.TransactionService;

public class TransactionServiceImpl implements TransactionService {
    private final OperationStrategy operationStrategy;

    public TransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.getOperationHandler(fruitTransaction.getOperation())
                    .handleTransaction(fruitTransaction);
        }
    }
}
