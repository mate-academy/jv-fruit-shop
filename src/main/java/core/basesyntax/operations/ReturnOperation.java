package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.service.Product;
import java.util.Map;

public class ReturnOperation implements Operation {
    @Override
    public void perform(Product product, int amount) {
        Map<Product, Integer> products = Storage.getProducts();
        if (!products.containsKey(product)) {
            throw new RuntimeException("There is no product of a type: "
                    + product.getName());
        }
        products.put(product, products.get(product) + amount);
    }
}
