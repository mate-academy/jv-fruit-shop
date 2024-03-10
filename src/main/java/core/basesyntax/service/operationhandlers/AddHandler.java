package core.basesyntax.service.operationhandlers;

import java.util.Map;

public class AddHandler implements OperationHandler {
    @Override
    public void handle(Map<String, Integer> map, String nameOfProduct, int quantity) {
        map.put(nameOfProduct, quantity);
    }
}
