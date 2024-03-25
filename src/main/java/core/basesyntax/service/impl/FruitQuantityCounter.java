package core.basesyntax.service.impl;

import core.basesyntax.dao.IFruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.IFruitQuantityCounter;
import java.util.HashMap;
import java.util.Map;

public class FruitQuantityCounter implements IFruitQuantityCounter {
    private final IFruitTransactionDao fruitTransactionDao;
    private final OperationStrategy operationStrategy;

    public FruitQuantityCounter(IFruitTransactionDao fruitTransactionDao,
                                OperationStrategy operationStrategy) {
        this.fruitTransactionDao = fruitTransactionDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> get() {
        Map<String, Integer> fruitQuantityMap = new HashMap<>();

        for (int i = 0; i < fruitTransactionDao.getLength(); i++) {
            FruitTransaction tempFruitTransaction = fruitTransactionDao.getByIndex(i);

            operationStrategy.get(tempFruitTransaction.operation())
                    .performOperation(tempFruitTransaction.name(),
                            tempFruitTransaction.quantity(), fruitQuantityMap);
        }
        return fruitQuantityMap;
    }
}
