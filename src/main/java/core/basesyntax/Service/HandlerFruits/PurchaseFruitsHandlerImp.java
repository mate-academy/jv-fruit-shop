package core.basesyntax.Service.HandlerFruits;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseFruitsHandlerImp implements FruitsHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer lastSum = Storage.fruits.get(fruitTransaction.getFruitName());
        Storage.fruits.put(fruitTransaction.getFruitName(),
                lastSum - fruitTransaction.getQuantity());
    }
}
