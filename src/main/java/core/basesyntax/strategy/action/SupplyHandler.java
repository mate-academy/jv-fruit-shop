package core.basesyntax.strategy.action;

import core.basesyntax.dao.ProductStorageDao;
import core.basesyntax.exception.ActionProductNotFoundException;
import core.basesyntax.model.ProductTransaction;

public class SupplyHandler implements ActionHandler {
    @Override
    public void process(ProductStorageDao productStorageDao, ProductTransaction transaction) {
        String productName = transaction.getProduct();
        int quantity = productStorageDao.getQuantity(productName).orElseThrow(() ->
                new ActionProductNotFoundException(String.format("Product %s not found in storage",
                        productName)));
        quantity += transaction.getQuantity();
        productStorageDao.setQuantity(productName, quantity);
    }
}
