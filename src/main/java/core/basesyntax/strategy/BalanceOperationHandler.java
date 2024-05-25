package core.basesyntax.strategy;

import java.util.HashMap;

public class BalanceOperationHandler implements OperationHandler {
    private static final int FRUIT = 1;
    private static final int NUMBER = 2;

    @Override
    public HashMap<String, Integer> processCommand(HashMap<String, Integer> map, String[] data) {
        map.put(data[FRUIT], Integer.valueOf(data[NUMBER]));
        return map;
    }
}
