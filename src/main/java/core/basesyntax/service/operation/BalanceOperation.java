package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.exceptions.RepeatedBalanceOperatorException;
import core.basesyntax.model.Fruit;

public class BalanceOperation implements Operation {
    @Override
    public void doOperation(Fruit fruit) {
        if (FruitStorage.fruits.contains(fruit)) {
            throw new RepeatedBalanceOperatorException(fruit);
        }
        FruitStorage.fruits.add(fruit);
    }
}
