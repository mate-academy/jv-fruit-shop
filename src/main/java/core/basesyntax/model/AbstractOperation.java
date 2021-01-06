package core.basesyntax.model;

import core.basesyntax.model.entities.Product;
import java.util.Map;

public abstract class AbstractOperation<T extends Product> implements Executable<T> {
    protected final Map<T, Integer> storage;

    public AbstractOperation(Map<T, Integer> storage) {
        this.storage = storage;
    }
}
