package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ProcessorData;
import java.util.List;

public class ProcessorDataImpl implements ProcessorData {
    private final OperationStrategy operationStrategy;

    public ProcessorDataImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processData(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .doOperation(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
