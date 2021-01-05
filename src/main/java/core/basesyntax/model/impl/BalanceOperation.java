package core.basesyntax.model.impl;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.AbstractOperation;
import core.basesyntax.model.entities.Product;

public class BalanceOperation<T extends Product> extends AbstractOperation<T> {
    public BalanceOperation(Warehouse<T> warehouse) {
        super(warehouse);
    }

    @Override
    public void execute(T product, Integer amount) {
        warehouse.getStorage().put(product, amount);
    }
}
