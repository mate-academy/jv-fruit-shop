package core.strategy;

import java.util.Map;

public interface FruitStrategy {
    OperationHandler getByOperation(String operation);

    Map<String, OperationHandler> getMap();
}
