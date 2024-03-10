package core.basesyntax.service.operationhandlers;

import java.util.Map;

public interface OperationHandler {
    public void handle(Map<String, Integer> map, String nameOfProduct, int quantity);
}
