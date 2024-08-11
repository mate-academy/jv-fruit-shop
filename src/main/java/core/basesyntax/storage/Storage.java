package core.basesyntax.storage;

import core.basesyntax.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
