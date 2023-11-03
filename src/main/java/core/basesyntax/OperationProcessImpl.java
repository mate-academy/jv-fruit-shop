package core.basesyntax;

import java.util.List;

public class OperationProcessImpl implements OperationProcess{
    private OperationStrategy operationStrategy;

    public OperationProcessImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransaction(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            operationStrategy.processOperation(transaction);
        }
    }
}
