package core.basesyntax.shopimpl.service;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.shopimpl.entity.IllegalPurchaseAmountException;
import java.util.Map;

public class Validator {
    public static void transactionValidator(AbstractItem item,
                                            int amount,
                                            Map<AbstractItem, Integer> storage) throws Exception {
        transactionValidator(amount);
        int currentAmount = storage.get(item);
        if (currentAmount < amount) {
            String message = String
                    .format("Sorry, out shop can't provide %d of %s's. We can offer you only %d",
                    amount,
                    item.getItemName(),
                    currentAmount);
            
            throw new IllegalPurchaseAmountException(message);
        }
    }
    
    public static void transactionValidator(Integer amount) {
        if (amount < 0) {
            throw new IllegalStateException();
        }
    }
}
