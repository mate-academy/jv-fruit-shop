package core.basesyntax.shopimpl.service;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.shopimpl.entity.Fruit;
import java.util.Map;

public class Validator {
    public static void transactionValidator(AbstractItem item,
                                            int amount,
                                            Map<Fruit, Integer> storage) {
        int currentAmount = storage.get(item);
        if (currentAmount < amount) {
            System.out.println("Sorry, out shop can't provide " + amount
                               + " of " + item + "s. We can offer you only " + currentAmount);
        }
    }
}
