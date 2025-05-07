package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int getQuantityFromStore(int prev, int value) {
        int newQuantity = value;

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
