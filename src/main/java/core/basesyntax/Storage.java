package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<String> fruitAvailable = new ArrayList<>();

    public List<String> getFruitTypes() {
        return fruitAvailable;
    }

    public void setFruitTypes(String fruitType) {
        fruitAvailable.add(fruitType);
    }
}
