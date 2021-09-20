package core.basesyntax.servise.activity;

import core.basesyntax.storage.Storage;

public class PurchaseActivityHandlerImpl implements ActivityHandler {
    @Override
    public void act(String fruit, String quantity) {
        Integer intQuantity = Integer.valueOf(quantity);
        if (Storage.fruitsDataBase.get(fruit) == null) {
            throw new RuntimeException("Balance wasn't first activity");
        }
        if (Storage.fruitsDataBase.get(fruit) < intQuantity) {
            throw new RuntimeException("You couldn't sale more than you had");
        }
        Storage.fruitsDataBase.put(fruit, Storage.fruitsDataBase.get(fruit) - intQuantity);
    }
}
