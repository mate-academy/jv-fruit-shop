package strategy;

import db.Storage;
import dto.ShopOperation;
import model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int apply(ShopOperation shopOperation) {
        int fruitAmount = shopOperation.getQuantity();
        Storage.storage.put(new Fruit(shopOperation.getFruitName()), fruitAmount);
        return fruitAmount;
    }
}
