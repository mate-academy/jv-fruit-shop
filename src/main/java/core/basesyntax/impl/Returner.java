package core.basesyntax.impl;

import core.basesyntax.model.FruitBox;
import core.basesyntax.model.Storage;
import core.basesyntax.service.Operator;
import core.basesyntax.service.SoldFruitCounter;
import java.time.LocalDate;

public class Returner implements Operator<FruitBox> {
    private static final LocalDate DATE_NOW = LocalDate.now();

    @Override
    public void execute(FruitBox fruit) {
        if (SoldFruitCounter.fruitCounter < fruit.getAmount()
                || fruit.getExpiryDate().isBefore(DATE_NOW)) {
            return;
        }
        Storage.storage.peek().setAmount(
                Storage.storage.peek().getAmount() + fruit.getAmount()
        );
    }
}
