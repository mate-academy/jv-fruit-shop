package core.basesyntax.strategy.action;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.exception.ActionProductNotFoundException;
import core.basesyntax.model.Product;
import core.basesyntax.model.ProductTransaction;

public class PurchaseHandler implements ActionHandler {
    @Override
    public void runAction(ProductDao productDao, ProductTransaction productTransaction) {
        String productName = productTransaction.getProduct();
        Product product = productDao.get(productName).orElseThrow(() ->
                new ActionProductNotFoundException(String.format("Product %s not found in storage",
                        productName)));
        product.setQuantity(product.getQuantity() - productTransaction.getQuantity());
        productDao.update(product);
    }
}
