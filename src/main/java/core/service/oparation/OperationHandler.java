package core.service.oparation;

import core.model.Fruit;
import java.util.Map;

public interface OperationHandler {
    void doOperation(Map<String, Fruit> fruitMap, String[] operation);
}
