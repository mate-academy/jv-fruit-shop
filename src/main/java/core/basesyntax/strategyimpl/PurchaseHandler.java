package core.basesyntax.strategyimpl;

import core.basesyntax.database.FruitStock;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final FruitStock fruitStock;

    public PurchaseHandler(FruitStock fruitStock) {
        this.fruitStock = fruitStock;
    }

    @Override
    public void handle(String fruit, int quantity) {
        int currentBalance = fruitStock.getQuantity(fruit);

        if (currentBalance < quantity) {
            throw new RuntimeException("Not enough fruit to buy: " + fruit);
        }
        fruitStock.updateFruitQuantity(fruit, currentBalance - quantity);
    }
}
