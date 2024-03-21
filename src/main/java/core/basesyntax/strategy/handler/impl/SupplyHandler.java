package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.dto.ProductTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class SupplyHandler extends OperationHandler {

    @Override
    public void handle(ProductTransaction productTransaction) {
        String product = productTransaction.product();
        int quantity = productTransaction.quantity();
        if (ProductStorage.storage.containsKey(product)) {
            ProductStorage.storage.put(
                    product, ProductStorage.storage.get(product) + quantity);
        }
        ProductStorage.storage.putIfAbsent(product, quantity);
    }
}
