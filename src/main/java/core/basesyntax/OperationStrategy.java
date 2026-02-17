package core.basesyntax;

import java.util.*;
import java.util.Map;

public interface OperationStrategy {
    public void handle(FruitTransaction transaction, Map<String, Integer> storage);
}
