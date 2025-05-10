package core.basesyntax.db;

import core.basesyntax.model.OperationType;
import java.util.Set;

public interface ShopStorage<T> {
    int getAmount(T t);

    void save(T item, int value, OperationType operationType);

    Set<T> getAllItems();
}
