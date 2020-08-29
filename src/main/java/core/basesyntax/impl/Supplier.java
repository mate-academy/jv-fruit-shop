package core.basesyntax.impl;

import core.basesyntax.model.FruitBox;
import core.basesyntax.model.Storage;
import core.basesyntax.service.Operator;

public class Supplier implements Operator<FruitBox> {
    @Override
    public void execute(FruitBox fruit) {
        if (Storage.storage.peek() == null) {
            Storage.storage.add(fruit);
            return;
        }
        if (Storage.storage.peek().getExpiryDate().equals(fruit.getExpiryDate())) {
            Storage.storage.peek().setAmount(Storage.storage.peek().getAmount()
                    + fruit.getAmount());
            return;
        }
        if (fruit.getExpiryDate().isBefore(Storage.storage.peek().getExpiryDate())) {
            Storage.storage.addFirst(fruit);
            return;
        }
        Storage.storage.add(fruit);
    }
}
