package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.FactoryStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final FactoryStrategy factoryStrategy;

    public FruitShopServiceImpl(FactoryStrategy factoryStrategy) {
        this.factoryStrategy = factoryStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        OperationHandler operationHandler;
        for (FruitTransaction transaction: fruitTransactions) {
            operationHandler = factoryStrategy.getFruitService(transaction.operation());
            operationHandler.handleFruitOperation(transaction.fruit(),
                    transaction.quantity());
        }
    }
}
