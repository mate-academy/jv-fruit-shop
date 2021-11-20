package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.Arrays;

public class FruitList {
    private final ArrayList<Fruit> fruitList;

    public FruitList() {
        this.fruitList = new ArrayList<>();
        fruitList.addAll(Arrays.asList(Fruit.values()));
    }

    public Fruit getFruitByName(String fruitName) {
        return fruitList.stream().filter(f -> f.getName().equals(fruitName)).findFirst().orElseThrow();
    }
}
