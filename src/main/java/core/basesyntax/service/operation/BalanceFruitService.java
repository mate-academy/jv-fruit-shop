package core.basesyntax.service.operation;

import core.basesyntax.service.model.FruitTransaction;

public class BalanceFruitService implements FruitService {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getValue());
    }

}
