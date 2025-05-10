package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {

    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy fruitTransactionStrategy) {
        this.operationStrategy = fruitTransactionStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruits) {
        fruits.forEach((f -> operationStrategy
                .getOperationStrategy(f.getOperation())
                .executeOperation(f.getFruit(), f.getQuantity())));
    }
}
