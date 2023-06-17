package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processOfOperations(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction current : fruitTransactions) {
            operationStrategy.get(current.getOperation()).operationHandler(current);
        }
    }
}
