package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitDto;
import core.basesyntax.service.FruitOperation;

public class FruitAddition implements FruitOperation {
    @Override
    public void apply(FruitDto fruitDto) {
        for (int i = 0; i < fruitDto.getQuantity(); i++) {
            Storage.fruits.add(new Fruit(fruitDto.getFruit()));
        }
    }
}
