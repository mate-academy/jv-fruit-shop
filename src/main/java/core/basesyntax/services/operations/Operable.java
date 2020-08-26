package core.basesyntax.services.operations;

import java.util.Map;

public interface Operable {
    boolean operate(Map<String, Map<String, Integer>> store, String[] data);
}
