package core.basesyntax.operations;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.service.Product;
import java.util.Map;

public class PurchaseOperation implements Operation {
    @Override
    public void perform(Product product, int amount, ProductDao productDao) {
        Map<Product, Integer> products = productDao.get();
        if (!products.containsKey(product)) {
            throw new RuntimeException("There is no product of a type: "
                    + product.getName());
        }
        int formerAmount = products.get(product);
        int newAmount = formerAmount - amount;
        if (newAmount < 0) {
            throw new RuntimeException("You can't buy " + amount + " of "
                    + product.getName() + " because there are only " + formerAmount);
        }
        products.put(product, newAmount);
    }
}
