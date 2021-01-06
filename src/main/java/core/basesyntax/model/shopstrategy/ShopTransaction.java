package core.basesyntax.model.shopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;
import java.util.Map;

public interface ShopTransaction {
    void apply(AbstractItem item, int amount, Map<AbstractItem, Integer> map);
}
