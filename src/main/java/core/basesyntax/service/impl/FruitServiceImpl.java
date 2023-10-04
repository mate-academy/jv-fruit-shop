package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {

    @Override
    public void calculateShoppingCart(List<FruitTransaction> list,
                                      OperationStrategy operationStrategy) {
        for (FruitTransaction fruitTransaction : list) {
            Storage.listFruits.compute(fruitTransaction.getFruit(),
                    (k,v) -> operationStrategy.get(fruitTransaction.getOperation())
                            .handle(v,fruitTransaction.getQuantity()));
        }
    }
}
