package core.basesyntax.service.impl;

import core.basesyntax.Fruit;
import core.basesyntax.FruitStorage;
import java.time.LocalDate;
import java.util.List;

public class BuyOperation implements core.basesyntax.service.Operational {
    private FruitStorage fruitStorage;

    public BuyOperation(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void apply(Fruit fruit) {
        fruitStorage.remove(fruit);
    }

    @Override
    public boolean enoughFresh(String name, LocalDate date, int demand) {
        List<Fruit> fruits = fruitStorage.getListOfFruits();
        long storageFruitCount = fruits.stream()
                .filter(fruit -> fruit.getName().equals(name) && fruit.getDate().isAfter(date))
                .count();
        if (demand > storageFruitCount) {
            throw new RuntimeException(String.format("Not enough fresh %s", name));
        }
        return true;
    }
}
