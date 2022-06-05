package core.basesyntax.strategy.action;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.Product;
import core.basesyntax.model.ProductTransaction;

public class BalanceHandler implements ActionHandler {
    @Override
    public void runAction(ProductDao productDao, ProductTransaction productTransaction) {
        Product product = new Product(productTransaction.getProduct());
        product.setQuantity(productTransaction.getQuantity());
        productDao.update(product);
    }
}
