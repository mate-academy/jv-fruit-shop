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
    public void usageOfStrategy(List<FruitTransaction> transaction) {
        for (FruitTransaction fruitTransaction : transaction) {
            fruitStrategy.getHandler(fruitTransaction.getOperation())
                    .changeFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
