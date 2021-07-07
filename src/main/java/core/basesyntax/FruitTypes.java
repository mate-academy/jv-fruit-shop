package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class FruitTypes {
    private List<String> fruitTypes = new ArrayList<>();

    public List<String> getFruitTypes() {
        fillFruitTypes();
        return fruitTypes;
    }

    public void setFruitTypes(String fruitType) {
        fruitTypes.add(fruitType);
    }

    public void fillFruitTypes() {
        setFruitTypes("apple");
        setFruitTypes("orange");
        setFruitTypes("grapes");
        setFruitTypes("banana");
        setFruitTypes("lemon");
        setFruitTypes("kiwi");
        setFruitTypes("mango");
        setFruitTypes("pear");
        setFruitTypes("peach");
    }
}
