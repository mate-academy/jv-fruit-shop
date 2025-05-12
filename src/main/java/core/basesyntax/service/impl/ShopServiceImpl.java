package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategyOperations;

    public ShopServiceImpl(OperationStrategy strategyOperations) {
        this.strategyOperations = strategyOperations;
    }

    @Override
    public void process(List<FruitTransaction> fruitsList) {
        for (FruitTransaction fruit : fruitsList) {
            strategyOperations.get(fruit.getOperation()).getCalculation(fruit);

        }
    }
}
