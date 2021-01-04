package core.basesyntax.model.shopstrategy;

import core.basesyntax.model.AbstractItem;

public interface ShopAction {
    void apply(AbstractItem item, int amount);
}
