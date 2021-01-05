package core.basesyntax.model;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Product;

public abstract class AbstractOperation<T extends Product> implements Executable<T> {
    protected Warehouse<T> warehouse;

    public AbstractOperation(Warehouse<T> warehouse) {
        this.warehouse = warehouse;
    }
}
