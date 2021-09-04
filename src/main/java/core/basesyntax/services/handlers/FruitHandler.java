package core.basesyntax.services.handlers;

import core.basesyntax.model.Operation;
import java.util.Map;

public interface FruitHandler {
    int newQuantity(Operation operation, Map<String, Integer> fruitStorage);
}
