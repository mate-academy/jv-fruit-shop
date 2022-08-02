package serviceimpl;

import java.util.List;
import model.FruitTransaction;
import service.TransactionProcessor;
import strategy.OperationStrategy;

public class TransactionImpl implements TransactionProcessor {
    private final OperationStrategy operationStrategy;

    public TransactionImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> data) {
        for (FruitTransaction fruitTransaction : data) {
            operationStrategy.getHandler(fruitTransaction.getOperation())
                    .handle(fruitTransaction);
        }
    }
}
