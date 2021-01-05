package core.basesyntax.model.impl;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.AbstractOperation;
import core.basesyntax.model.entities.Product;

public class ReturnOperation<T extends Product> extends AbstractOperation<T> {
    public ReturnOperation(Warehouse<T> warehouse) {
        super(warehouse);
    }

    @Override
    public void execute(T product, Integer amount) {
        warehouse.getStorage().merge(product, amount, Integer::sum);
    }
}
