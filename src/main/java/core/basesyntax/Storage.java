package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<ProductBox> fruitSupplies = new ArrayList<>();

    public List<ProductBox> getFruitSupplies() {
        return fruitSupplies;
    }

    public void addProductBox(ProductBox productBox) {
        fruitSupplies.add(productBox);
    }

    public void removeProductBox(ProductBox productBox) {
        fruitSupplies.remove(productBox);
    }
}
