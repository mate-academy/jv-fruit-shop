package serviceimpl;

import java.util.List;
import model.FruitTransaction;
import service.Transaction;
import strategy.OperationStrategy;

public class TransactionImpl implements Transaction {
    private final OperationStrategy operationStrategy;

    public TransactionImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> data) {
        for (FruitTransaction fruitTransaction : data) {
            operationStrategy.getHandler(fruitTransaction.getOperation())
                    .apply(fruitTransaction);
        }
    }
}
