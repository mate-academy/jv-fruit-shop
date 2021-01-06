package core.basesyntax.shopimpl.service;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopstrategy.ShopTransactionsType;
import core.basesyntax.shopimpl.entity.IllegalPurchaseAmountException;
import java.util.Map;

public class Validator {
    public static void transactionValidator(AbstractItem item,
                                            int amount,
                                            Map<AbstractItem, Integer> storage) throws Exception {
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
    
    public static void transactionValidator(ShopTransactionsType transactionsType,
                                            AbstractItem item,
                                            Integer amount) {
        if (transactionsType == null || item == null || amount == null) {
            throw new RuntimeException("NonNull arguments expected");
        }
    }
}
