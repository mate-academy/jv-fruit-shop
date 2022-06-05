package core.basesyntax.strategy.action;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.exception.ProductNotFoundException;
import core.basesyntax.model.Product;
import core.basesyntax.model.ProductTransaction;

public class SupplyHandler implements ActionHandler {
    @Override
    public void runAction(ProductDao productDao, ProductTransaction productTransaction) {
        String productName = productTransaction.getProduct();
        Product product = productDao.get(productName).orElseThrow(() ->
                new ProductNotFoundException(String.format("Product %s not found in storage",
                        productName)));
        product.setQuantity(product.getQuantity() + productTransaction.getQuantity());
        productDao.update(product);
    }
}
