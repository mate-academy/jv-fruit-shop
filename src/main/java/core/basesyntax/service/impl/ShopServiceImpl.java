package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.FruitStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private FruitStrategy fruitStrategy;

    public ShopServiceImpl(FruitStrategy fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactionList) {
        transactionList
                .forEach(transaction -> fruitStrategy.get(transaction.getOperation())
                        .performOperation(transaction));
    }
}
