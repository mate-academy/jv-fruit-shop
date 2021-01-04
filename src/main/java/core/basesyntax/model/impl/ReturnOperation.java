package core.basesyntax.model.impl;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.AbstractOperation;
import core.basesyntax.model.entities.Product;

import java.util.Map;

public class ReturnOperation<T extends Product> extends AbstractOperation<T> {
    public ReturnOperation(Warehouse<T> warehouse) {
        super(warehouse);
    }

    @Override
    public void execute(T product, Integer amount) {
        Map<T, Integer> storage = warehouse.getStorage();
        storage.put(product, storage.get(product) + amount);
    }
}
