package core.basesyntax.servise.activity;

import java.util.Map;

public class PurchaseActivityHandler implements ActivityHandler {
    @Override
    public void action(String fruit, String quantity, Map<String, Integer> goalMap) {
        Integer intQuantity = Integer.valueOf(quantity);
        if (goalMap.get(fruit) == null || goalMap.get(fruit) < intQuantity) {
            throw new RuntimeException("Date don't correct");
        }
        goalMap.put(fruit, goalMap.get(fruit) - intQuantity);
    }
}
