package core.service.oparation;

import core.model.Fruit;
import java.util.Map;

public interface OperationHandler {
    void doOperation(Map<Fruit, Integer> fruitMap, String[] operation);
}
