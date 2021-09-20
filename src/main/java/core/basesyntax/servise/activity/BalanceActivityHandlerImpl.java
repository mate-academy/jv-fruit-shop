package core.basesyntax.servise.activity;

import core.basesyntax.storage.Storage;

public class BalanceActivityHandlerImpl implements ActivityHandler {
    @Override
    public void act(String fruit, String quantity) {
        Integer intQuantity = Integer.valueOf(quantity);
        if (Storage.fruitsDataBase.get(fruit) != null) {
            throw new RuntimeException("Balance isn't first activity");
        }
        Storage.fruitsDataBase.put(fruit, intQuantity);
    }
}
