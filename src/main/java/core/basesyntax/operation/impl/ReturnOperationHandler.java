package core.basesyntax.operation.impl;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.model.Product;
import core.basesyntax.model.Transaction;
import core.basesyntax.operation.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private final ProductStorage productStorage;

    public ReturnOperationHandler(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    @Override
    public void execute(Transaction transaction) {
        Product product = productStorage.getByName(transaction.getProduct().getName());
        product.setQuantity(product.getQuantity() + transaction.getProduct().getQuantity());
        productStorage.put(product);
    }
}
