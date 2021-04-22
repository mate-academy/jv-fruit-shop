package core.basesyntax.operations;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.service.Product;
import java.util.Map;

public class BalanceOperation implements Operation {
    @Override
    public void perform(Product product, int amount, ProductDao productDao) {
        Map<Product, Integer> products = productDao.get();
        if (products.containsKey(product)) {
            throw new RuntimeException("Storage already contains this type of product: "
                    + product.getName());
        }
        products.put(product, amount);
    }
}
