package core.basesyntax.impl;

import core.basesyntax.Returner;
import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import java.time.LocalDate;

public class FruitReturn implements Returner<Fruit> {
    private static final LocalDate NOW_DATE = LocalDate.now();

    @Override
    public void returnFruit(Fruit fruit) {
        if (Storage.fruitStorage.peek() != null && FruitCounter.fruitsSold >= fruit.amount) {
            if (fruit.getExpDate().isBefore(NOW_DATE)) {
                return;
            }
            Storage.fruitStorage.peek().amount += fruit.amount;
        }
    }
}
