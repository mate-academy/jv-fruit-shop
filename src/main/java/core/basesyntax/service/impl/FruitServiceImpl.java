package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.FruitStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    @Override
    public void getAllTypeStrategy(List<FruitTransaction> fruitTransactionsList,
                                   FruitStrategy fruitStrategy) {
        for (FruitTransaction fruitTransaction: fruitTransactionsList) {
            fruitStrategy.get(fruitTransaction.getOperation())
                    .handle(fruitTransaction);
        }
    }
}
