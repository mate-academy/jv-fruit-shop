package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BuyOperationHandler implements OperationHandler {
    @Override
    public void action(FruitTransaction fruitTransaction) {
        reduceIf(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }

    private void reduceIf(String name, int quantity) {
        if (Storage.fruits.containsKey(name) && Storage.fruits.get(name) >= quantity) {
            Storage.fruits.put(name, Storage.fruits.get(name) - quantity);
        } else {
            throw new RuntimeException("Not enough " + name + " to sell!");
        }
    }
}
