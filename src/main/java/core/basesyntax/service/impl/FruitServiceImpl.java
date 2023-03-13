package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.FruitStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private FruitStrategy fruitStrategy;

    public FruitServiceImpl(FruitStrategy fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public void action(List<FruitTransaction> transaction) {
        for (FruitTransaction fruitTransaction : transaction) {
            fruitStrategy.get(fruitTransaction.getOperation())
                    .activities(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
