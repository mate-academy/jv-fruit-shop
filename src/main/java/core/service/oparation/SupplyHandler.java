package core.service.oparation;

import core.model.Fruit;
import java.util.Map;

public class SupplyHandler extends AddOperationHandler {
    @Override
    public void doOperation(Map<Fruit, Integer> fruitMap, String[] operation) {
        super.doOperation(fruitMap, operation);
    }
}
