package core.basesyntax.shopimpl.service;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.shopimpl.entity.Fruit;
import core.basesyntax.shopimpl.entity.IllegalPurchaseAmountException;
import java.util.Map;

public class Validator {
    public static void transactionValidator(AbstractItem item,
                                            int amount,
                                            Map<Fruit, Integer> storage) throws Exception {
        int currentAmount = storage.get(item);
        if (currentAmount < amount) {
            throw new IllegalPurchaseAmountException("Sorry, out shop can't provide " + amount
                                                     + " of " + item + "s. We can offer you only "
                                                     + currentAmount);
        }
    }
}
