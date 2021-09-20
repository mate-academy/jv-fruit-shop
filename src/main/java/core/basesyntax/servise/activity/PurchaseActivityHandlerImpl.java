package core.basesyntax.servise.activity;

import java.util.Map;

public class PurchaseActivityHandlerImpl implements ActivityHandler {
    @Override
    public void act(String fruit, String quantity, Map<String, Integer> goalMap) {
        Integer intQuantity = Integer.valueOf(quantity);
        if (goalMap.get(fruit) == null) {
            throw new RuntimeException("Balance wasn't first activity");
        }
        if (goalMap.get(fruit) < intQuantity) {
            throw new RuntimeException("You couldn't sale more than you had");
        }
        goalMap.put(fruit, goalMap.get(fruit) - intQuantity);
    }
}
