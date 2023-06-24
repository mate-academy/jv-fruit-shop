package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {

    @Override
    public void processFruit(List<FruitTransaction> fruitTransactionList,
                             OperationStrategy operationStrategy) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler operationHandler = operationStrategy.get(fruitTransaction
                    .getOperation());
            operationHandler.operation(fruitTransaction);
        }
    }
}
