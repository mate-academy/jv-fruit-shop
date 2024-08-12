package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Fruit> fruits = new ArrayList<>();

    public List<Fruit> getProducts() {
        return fruits;
    }

    public void setProducts(List<Fruit> fruits) {
        this.fruits = fruits;
    }
}
