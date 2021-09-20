package core.service.oparation;

import core.model.Fruit;
import java.util.Map;

public class ReturnHandler extends AddOperationHandler {
    @Override
    public void doOperation(Map<String, Fruit> fruitMap, String[] operation) {
        super.doOperation(fruitMap, operation);
    }
}
