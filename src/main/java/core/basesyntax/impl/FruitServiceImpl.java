package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final int ZERO = 0;
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void calculateFruit(List<FruitTransaction> fruits) {
        for (FruitTransaction fruitTransaction : fruits) {
            int fruitQuantity = fruitTransaction.getQuantity();
            int operation = operationStrategy.get(fruitTransaction.getOperation())
                    .getOperation(fruitTransaction.getQuantity());
            int resultQ = fruitQuantity + operation != ZERO ? fruitQuantity : -fruitQuantity;
            if (Storage.fruits.get(fruitTransaction.getFruit()) != null) {
                Storage.fruits.put(fruitTransaction.getFruit(),
                        Storage.fruits.get(fruitTransaction.getFruit()) + resultQ);
                continue;
            }
            Storage.fruits.put(fruitTransaction.getFruit(), resultQ);
        }
    }
}
