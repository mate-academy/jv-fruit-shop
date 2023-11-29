package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Fruit> listOfFruits = new ArrayList<>();

    public List<Fruit> getListOfFruits() {
        return listOfFruits;
    }
}
