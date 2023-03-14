package core.basesyntax.strategy.actions;

import java.util.Map;

public class BaseActionHandler implements ActionHandler {
    @Override
    public void apply(Map<String, Integer> map, String data) {
        String[] values = data.split(SPLITTER, 2);
        Integer value = Integer.parseInt(values[1]);
        map.put(values[0], value);
    }

    @Override
    public boolean isApplicable(String action) {
        return action.equals("b");
    }
}
