package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ProcessDataServiceImpl implements ProcessDataService {
    private OperationStrategy operationStrategy;

    public ProcessDataServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processData(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.getOperation(fruitTransaction.getOperation())
                    .completeOperation(fruitTransaction.getFruitName(),
                            fruitTransaction.getQuantity());
        }
    }
}
