package core.basesyntax.strategy;

import java.util.HashMap;

public class SupplyOperationHandler implements OperationHandler {
    private static final int FRUIT = 1;
    private static final int NUMBER = 2;

    @Override
    public HashMap<String, Integer> processCommand(HashMap<String, Integer> map, String[] data) {
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            if (key.equals(data[FRUIT])) {
                value += Integer.parseInt(data[NUMBER]);
            }
            map.replace(key, value);
        }
        return map;
    }
}
