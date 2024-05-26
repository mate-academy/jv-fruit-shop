package core.basesyntax.strategy;

import java.util.HashMap;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public HashMap<String, Integer> processCommand(HashMap<String, Integer> map, String[] data) {
        map.put(data[FRUIT], Integer.valueOf(data[QUANTITY]));
        return map;
    }
}
