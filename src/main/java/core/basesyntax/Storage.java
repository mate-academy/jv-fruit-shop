package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<FruitPackage> fruitPackages;

    public Storage() {
        fruitPackages = new ArrayList<>();
    }

    public List<FruitPackage> getFruitPackages() {
        return fruitPackages;
    }
}
