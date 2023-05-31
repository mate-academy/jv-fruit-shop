package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.FruitShopStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final FruitShopStrategy fruitShopStrategy;

    public FruitShopServiceImpl(FruitShopStrategy fruitShopStrategy) {
        this.fruitShopStrategy = fruitShopStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(fruitShopStrategy::handle);
    }
}
