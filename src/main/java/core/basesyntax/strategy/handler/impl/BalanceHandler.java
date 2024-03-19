package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.exception.BalanceReassigningException;
import core.basesyntax.models.Fruit;
import core.basesyntax.strategy.handler.OperationHandler;

public class BalanceHandler extends OperationHandler {

    public BalanceHandler(FruitStorage fruitStorage) {
        super(fruitStorage);
    }

    @Override
    public void handle(Fruit fruit, Integer quantity) {
        if (fruitStorage.storage().containsKey(fruit)) {
            throw new BalanceReassigningException("Balance can`t be reassigned! "
                    + "You have duplicate balance operation for fruit: " + fruit.fruitName());
        }
        fruitStorage.storage().putIfAbsent(fruit, quantity);
    }
}
