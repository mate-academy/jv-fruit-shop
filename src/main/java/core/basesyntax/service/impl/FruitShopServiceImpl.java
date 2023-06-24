package core.basesyntax.service.impl;

import core.basesyntax.service.model.FruitTransaction;
import core.basesyntax.service.service.FruitShopService;
import core.basesyntax.service.strategy.FruitHandler;
import core.basesyntax.service.strategy.Strategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final Strategy strategy;

    public FruitShopServiceImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void realizePattern(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            FruitHandler service = strategy.choosePattern(fruitTransaction);
            service.apply(fruitTransaction);
        }
    }
}
