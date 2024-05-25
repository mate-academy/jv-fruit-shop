package core.basesyntax.strategy;

import java.util.HashMap;

public interface OperationHandler {
    HashMap<String, Integer> processCommand(HashMap<String, Integer> map, String[] data);
}
