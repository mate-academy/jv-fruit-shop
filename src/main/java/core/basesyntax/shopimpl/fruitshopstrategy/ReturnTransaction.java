package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopstrategy.ShopTransaction;
import java.util.Map;

public class ReturnTransaction implements ShopTransaction {
    
    @Override
    public void apply(AbstractItem item, int amount, Map<AbstractItem, Integer>  storage) {
        int update = storage.get(item) + amount;
        storage.put(item, update);
    }
}
