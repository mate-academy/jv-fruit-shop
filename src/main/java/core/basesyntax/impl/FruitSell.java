package core.basesyntax.impl;

import core.basesyntax.Consumer;
import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import java.time.LocalDate;

public class FruitSell implements Consumer<Fruit> {
    public static final LocalDate NOW_DATE = LocalDate.now();

    @Override
    public void sellFruit(Fruit fruit) {
        if (Storage.fruitStorage.peek() == null) {
            throw new NullPointerException("Storage is empty!");
        }
        if (Storage.fruitStorage.peek().amount < fruit.amount
                && Storage.fruitStorage.peek().getExpDate().isBefore(NOW_DATE)) {
            int count = Storage.fruitStorage.peek().amount;
            if (Storage.fruitStorage.peek() != null
                    && Storage.fruitStorage.peek().amount + count >= fruit.amount) {
                Storage.fruitStorage.poll();
                Storage.fruitStorage.peek().amount += count - fruit.amount;
                FruitCounter.fruitsSold = fruit.amount;
            }
        } else {
            if (Storage.fruitStorage.peek().amount - fruit.amount < 0) {
                return;
            }
            Storage.fruitStorage.peek().amount -= fruit.amount;
            FruitCounter.fruitsSold = fruit.amount;
        }
    }
}
