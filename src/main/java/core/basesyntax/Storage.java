package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Product> fruitList = new ArrayList<>();

    public List<Product> getFruitList() {
        return fruitList;
    }

    public void addProductBox(Product product) {
        fruitList.add(product);
    }

    public void removeProductBox(Product product) {
        fruitList.remove(product);
    }
}
