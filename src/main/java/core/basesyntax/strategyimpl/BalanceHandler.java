package core.basesyntax.strategyimpl;

import core.basesyntax.database.FruitStock;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final FruitStock fruitStock;

    public BalanceHandler(FruitStock fruitStock) {
        this.fruitStock = fruitStock;
    }

    @Override
    public void handle(String fruit, int quantity) {
        fruitStock.updateFruitQuantity(fruit, quantity);
    }
}
