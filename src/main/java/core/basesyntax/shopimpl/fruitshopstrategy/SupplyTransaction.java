package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopstrategy.ShopTransaction;
import core.basesyntax.shopimpl.entity.Fruit;
import core.basesyntax.shopimpl.service.Validator;
import java.util.Map;

public class SupplyTransaction implements ShopTransaction {
    @Override
    public void apply(AbstractItem item, int amount, Map<AbstractItem, Integer> storage) {
        Validator.transactionValidator(amount);
        if (storage.containsKey(item)) {
            int update = storage.get(item) + amount;
            storage.put((Fruit) item, update);
            return;
        }
        storage.put((Fruit) item, amount);
    }
}
