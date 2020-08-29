package core.basesyntax.impl;

import core.basesyntax.model.FruitBox;
import core.basesyntax.service.Operator;
import core.basesyntax.service.FruitCounter;
import java.time.LocalDate;

public class Returner implements Operator<FruitBox> {
    private static final LocalDate DATE_NOW = LocalDate.now();

    @Override
    public void execute(FruitBox fruit) {
        Operator<FruitBox> supplier = new Supplier();
        if (FruitCounter.fruitCounter < fruit.getAmount()
                || fruit.getExpiryDate().isBefore(DATE_NOW)) {
            throw new RuntimeException("We can not accept this fruits!");
        }
        supplier.execute(fruit);
    }
}
