package core.basesyntax.strategyimpl;

import core.basesyntax.database.FruitStock;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private final FruitStock fruitStock;

    public SupplyHandler(FruitStock fruitStock) {
        this.fruitStock = fruitStock;
    }

    @Override
    public void handle(String fruit, int quantity) {
        fruitStock.add(fruit, quantity);
    }
}
