package core.basesyntax.strategy.actions;

import java.util.Map;
import java.util.Optional;

public class ReturnActionHandler implements ActionHandler {
    @Override
    public void apply(Map<String, Integer> map, String data) {
        String[] values = data.split(SPLITTER, 2);
        Integer initialAmount = Optional.ofNullable(map.get(values[0]))
                .orElseThrow(() -> new RuntimeException("Fruit index does not exist"));
        Integer value = Integer.parseInt(values[1]) + map.get(values[0]);
        if (value > initialAmount) {
            throw new RuntimeException("Can't return more than there is in stock");
        }
        map.put(values[0], value);
    }

    @Override
    public boolean isApplicable(String action) {
        return "r".equals(action);
    }
}
