package core.basesyntax.servise.activity;

import java.util.Map;

public class BalanceActivityHandler implements ActivityHandler {
    @Override
    public void action(String fruit, String quantity, Map<String, Integer> goalMap) {
        Integer intQuantity = Integer.valueOf(quantity);
        if (goalMap.get(fruit) != null) {
            throw new RuntimeException("Date don't correct");
        }
        goalMap.put(fruit, intQuantity);
    }
}
