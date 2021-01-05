package core.basesyntax.model.impl;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.AbstractOperation;
import core.basesyntax.model.entities.Product;

public class PurchaseOperation<T extends Product> extends AbstractOperation<T> {
    public PurchaseOperation(Warehouse<T> warehouse) {
        super(warehouse);
    }

    @Override
    public void execute(T product, Integer amount) {
        warehouse.getStorage().merge(product, amount, (a, b) -> a - b);
    }
}
