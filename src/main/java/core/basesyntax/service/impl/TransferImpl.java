package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Transfer;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransferImpl implements Transfer {
    private OperationStrategy operationStrategy;

    public TransferImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void generateInfo(List<FruitTransaction> info) {
        for (FruitTransaction fruitTransaction : info) {
            operationStrategy.get(fruitTransaction.getOperation()).process(fruitTransaction);
        }
    }
}
