package core.basesyntax.service.impl;

import core.basesyntax.Fruit;
import core.basesyntax.FruitStorage;
import core.basesyntax.service.Operational;
import java.time.LocalDate;

public class SupplyOrReturnOperation implements Operational {
    private FruitStorage fruitStorage;

    public SupplyOrReturnOperation(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void apply(Fruit fruit) {
        fruitStorage.add(fruit);
    }

    @Override
    public boolean enoughFresh(String name, LocalDate date, int demand) {
        return true;
    }
}
