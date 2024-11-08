package core.basesyntax.service;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.model.AbstractTransaction;
import java.util.List;

public interface ShopCalculationService<T> {
    FruitShopStorage calculate(List<AbstractTransaction<T>> transactions);
}
