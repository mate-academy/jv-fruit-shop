package core.basesyntax.service.impl;

import core.basesyntax.Fruit;
import core.basesyntax.FruitTransaction;
import core.basesyntax.service.Convertable;

public class ConvertToFruit implements Convertable<Fruit, FruitTransaction> {
    @Override
    public Fruit convert(FruitTransaction row) {
        Fruit fruit = new Fruit();
        fruit.setName(row.getFruit());
        fruit.setDate(row.getDate());
        return fruit;
    }
}
