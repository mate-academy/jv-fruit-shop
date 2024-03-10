package core.basesyntax.service.operationhandlers;

import java.util.Map;

public class SubtractHandler implements OperationHandler {
    @Override
    public void handle(Map<String, Integer> map, String nameOfProduct, int quantity) {
        map.replace(nameOfProduct, map.get(nameOfProduct) - quantity);
    }
}
