package core.basesyntax.service;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Product;

public abstract class AbstractService<T extends Product> {

    protected final Warehouse<T> warehouse;

    public AbstractService() {
        warehouse = new Warehouse<>();
    }

    public Warehouse<T> getWarehouse() {
        return warehouse;
    }

}
