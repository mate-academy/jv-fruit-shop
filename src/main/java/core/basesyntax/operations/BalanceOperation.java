package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.service.Product;
import java.util.Map;

public class BalanceOperation implements Operation {
    @Override
    public void perform(Product product, int amount) {
        Map<Product, Integer> products = Storage.getProducts();
        if (products.containsKey(product)) {
            throw new RuntimeException("Storage already contains this type of product: "
                    + product.getName());
        }
        products.put(product, amount);
    }
}
