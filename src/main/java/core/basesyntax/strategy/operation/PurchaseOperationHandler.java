package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getQuantityFromStore(int prev, int value) {
        if (value > prev) {
            throw new IllegalArgumentException("Cannot purchase more than "
                    + "available in stock. Requested: "
                    + value + ", Available: " + prev);
        }

        int newQuantity = prev - value;

        for (int i = 0; i < Storage.SHOP_STORE.size(); i++) {
            FruitOperation fruit = Storage.SHOP_STORE.get(i);
            if (fruit.getFruit().equals(fruit.getFruit())) {
                fruit.setQuantity(newQuantity);
                break;
            }
        }
        return newQuantity;
    }
}
