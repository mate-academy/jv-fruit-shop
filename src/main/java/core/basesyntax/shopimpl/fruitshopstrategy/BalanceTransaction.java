package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopstrategy.ShopTransaction;
import core.basesyntax.shopimpl.service.Validator;
import java.util.Map;

public class BalanceTransaction implements ShopTransaction {
    
    @Override
    public void apply(AbstractItem item, int amount, Map<AbstractItem, Integer> storage) {
        Validator.transactionValidator(amount);
        storage.put(item, amount);
    }
}
