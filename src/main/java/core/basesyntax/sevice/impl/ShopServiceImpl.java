package core.basesyntax.sevice.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.Strategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final Strategy strategy;

    public ShopServiceImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction: fruitTransactions) {
            strategy.get(fruitTransaction.getOperation())
                    .processOperation(fruitTransaction);
        }
    }
}
