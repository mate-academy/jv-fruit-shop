package core.basesyntax.servise.activity;

import core.basesyntax.storage.Storage;

public class ReturnActivityHandlerImpl implements ActivityHandler {
    @Override
    public void act(String fruit, String quantity) {
        Integer intQuantity = Integer.valueOf(quantity);
        if (Storage.fruitsDataBase.get(fruit) == null) {
            throw new RuntimeException("Balance wasn't first activity");
        }
        Storage.fruitsDataBase.put(fruit, Storage.fruitsDataBase.get(fruit) + intQuantity);
    }
}
