package core.basesyntax.strategy.actions;

import java.util.Map;
import java.util.Optional;

public class PurchaseActionHandler implements ActionHandler {
    @Override
    public void apply(Map<String, Integer> map, String data) {
        String[] values = data.split(SPLITTER, 2);
        Integer purchasedAmount = Integer.parseInt(values[1]);
        Integer initialAmount = Optional.ofNullable(map.get(values[0]))
                .orElseThrow(() -> new RuntimeException("Fruit index does not exist"));
        if (purchasedAmount > initialAmount) {
            throw new RuntimeException("Can't purchase more than there is in stock");
        }
        map.put(values[0], initialAmount - purchasedAmount);
    }

    @Override
    public boolean isApplicable(String action) {
        return action.equals("p");
    }
}
