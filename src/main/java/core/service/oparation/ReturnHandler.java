package core.service.oparation;

import core.model.Fruit;
import java.util.Map;

public class ReturnHandler implements OperationHandler {
    private static final int INDEX_NAME_FRUIT = 1;
    private static final int INDEX_QUANTITY_FRUIT = 2;

    @Override
    public void doOperation(Map<String, Fruit> fruitMap, String[] operation) {
        String nameFruit = operation[INDEX_NAME_FRUIT];
        int quantity = Integer.parseInt(operation[INDEX_QUANTITY_FRUIT]);
        Fruit fruit = fruitMap.get(nameFruit);
        fruit.setQuantity(fruit.getQuantity() + quantity);
    }
}
