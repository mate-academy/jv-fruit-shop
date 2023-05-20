package core.basesyntax.process;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationStrategy;
import java.util.List;

public class FruitDataProcessImpl implements FruitDataProcess {
    private OperationStrategy operationStrategy;

    public FruitDataProcessImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processFruitData(List<FruitTransaction> fruitTransactionList) {
        if (fruitTransactionList.isEmpty()) {
            throw new RuntimeException("Empty list: " + fruitTransactionList);
        }
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            operationStrategy.getHandler(fruitTransaction.getOperation());
        }
    }
}
