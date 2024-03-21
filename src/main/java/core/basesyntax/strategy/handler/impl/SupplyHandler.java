package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.dto.ProductTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class SupplyHandler extends OperationHandler {

    public SupplyHandler(ProductStorage productStorage) {
        super(productStorage);
    }

    @Override
    public void handle(ProductTransaction productTransaction) {
        String product = productTransaction.product();
        int quantity = productTransaction.quantity();
        if (productStorage.getStorage().containsKey(product)) {
            productStorage.getStorage().put(
                    product, productStorage.getStorage().get(product) + quantity);
        }
        productStorage.getStorage().putIfAbsent(product, quantity);
    }
}
