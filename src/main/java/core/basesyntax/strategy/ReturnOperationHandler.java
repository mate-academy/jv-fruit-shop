package core.basesyntax.strategy;

import java.util.HashMap;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public HashMap<String, Integer> processCommand(HashMap<String, Integer> map, String[] data) {
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            if (key.equals(data[FRUIT])) {
                value += Integer.parseInt(data[QUANTITY]);
            }
            map.replace(key, value);
        }
        return map;
    }
}
