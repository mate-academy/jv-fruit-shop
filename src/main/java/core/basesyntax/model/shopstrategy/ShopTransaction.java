package core.basesyntax.model.shopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;

public interface ShopTransaction {
    void apply(AbstractItem item, int amount);
}
