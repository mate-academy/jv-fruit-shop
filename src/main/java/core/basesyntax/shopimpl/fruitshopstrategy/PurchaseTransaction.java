package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopstrategy.ShopTransaction;
import core.basesyntax.shopimpl.entity.IllegalPurchaseAmountException;
import core.basesyntax.shopimpl.service.Validator;
import java.util.Map;

public class PurchaseTransaction implements ShopTransaction {
    @Override
    public void apply(AbstractItem item, int amount, Map<AbstractItem, Integer> storage) {
        try {
            Validator.transactionValidator(item, amount, storage);
            int update = storage.get(item) - amount;
            storage.put(item, update);
        } catch (IllegalPurchaseAmountException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong while validating transaction");
        }
    }
}
