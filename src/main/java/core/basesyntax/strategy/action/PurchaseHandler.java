package core.basesyntax.strategy.action;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.exception.ProductNegativeQuantityException;
import core.basesyntax.exception.ProductNotFoundException;
import core.basesyntax.model.Product;
import core.basesyntax.model.ProductTransaction;

public class PurchaseHandler implements ActionHandler {
    @Override
    public void runAction(ProductDao productDao, ProductTransaction productTransaction) {
        String productName = productTransaction.getProduct();
        Product product = productDao.get(productName).orElseThrow(() ->
                new ProductNotFoundException(String.format("Product %s not found in storage",
                        productName)));
        int newProductQuantity = product.getQuantity() - productTransaction.getQuantity();
        if (newProductQuantity < 0) {
            throw new ProductNegativeQuantityException(
                    String.format("Quantity of product %s has negative value", productName));
        }
        product.setQuantity(newProductQuantity);
        productDao.update(product);
    }
}
