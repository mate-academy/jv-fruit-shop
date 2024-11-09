package core.basesyntax.service;

import core.basesyntax.db.ShopStorage;
import core.basesyntax.model.AbstractTransaction;
import java.util.List;

public interface ShopCalculationService<T> {
    ShopStorage<T> calculate(List<AbstractTransaction<T>> transactions);
}
