package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BuyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        reduceIfPresent(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }

    private void reduceIfPresent(String name, int quantity) {
        if (Storage.fruits.containsKey(name)) {
            int quantityInStore = Storage.fruits.get(name);
            if (quantityInStore >= quantity) {
                Storage.fruits.put(name, quantityInStore - quantity);
            } else {
                throw new RuntimeException("Not enough '" + name + "' to sell!");
            }
        } else {
            throw new RuntimeException("Not found '" + name + "' fruit in Store!");
        }
    }
}
