package core.basesyntax.impl;

import core.basesyntax.model.FruitBox;
import core.basesyntax.model.Storage;
import core.basesyntax.service.Operator;
import core.basesyntax.service.SoldFruitCounter;

public class Returner implements Operator<FruitBox> {
    @Override
    public void execute(FruitBox fruit) {
        if (SoldFruitCounter.fruitCounter < fruit.getAmount()) {
            throw new IllegalArgumentException("We did not sell that much fruits");
        }
        Storage.storage.peek().setAmount(
                Storage.storage.peek().getAmount() + fruit.getAmount()
        );
    }
}
