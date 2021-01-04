package core.basesyntax.shopimpl.service;

import core.basesyntax.model.AbstractItem;
import java.util.Map;

public class Validator {
    public static void validate(AbstractItem item,
                                int amount,
                                Map<AbstractItem, Integer> storage) {
        int currentAmount = storage.get(item);
        if (currentAmount < amount) {
            System.out.println("Sorry, out shop can't provide " + amount
                               + " of " + item + "s. We can offer you only " + currentAmount);
        }
    }
}
