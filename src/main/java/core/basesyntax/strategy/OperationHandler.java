package core.basesyntax.strategy;

import java.util.HashMap;

public interface OperationHandler {
    int FRUIT = 1;
    int QUANTITY = 2;

    HashMap<String, Integer> processCommand(HashMap<String, Integer> map, String[] data);
}
