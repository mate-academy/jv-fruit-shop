package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.FruitStrategy;

public class FruitServiceImpl implements FruitService {
    private FruitStrategy fruitStrategy;

    public FruitServiceImpl(FruitStrategy fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public void transfer(FruitTransaction transaction) {
         fruitStrategy.get(transaction.getOperation())
                 .getActivities(transaction.getFruit(), transaction.getQuantity());
    }
}
