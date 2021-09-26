package core.basesyntax.service.strategy;

import core.basesyntax.model.*;
import java.util.*;

public interface OperationHandler {
    int get(FruitRecord fruitRecord, Map<String, Integer> storage);
}
