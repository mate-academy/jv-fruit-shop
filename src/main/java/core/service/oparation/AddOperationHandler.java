package core.service.oparation;

import core.controller.FruitShop;
import core.model.Fruit;
import java.util.Map;

public class AddOperationHandler implements OperationHandler {
    protected static final int INDEX_NAME_FRUIT = 1;
    protected static final int INDEX_QUANTITY_FRUIT = 2;

    @Override
    public void doOperation(Map<Fruit, Integer> fruitMap, String[] operation) {
        String nameFruit = operation[INDEX_NAME_FRUIT];
        Fruit fruit = new Fruit(nameFruit);
        int addQuantity = Integer.parseInt(operation[INDEX_QUANTITY_FRUIT]);
        int oldQuantity = FruitShop.STORAGE.getFruitStorageMap().get(fruit);
        FruitShop.STORAGE.getFruitStorageMap()
                .put(new Fruit(nameFruit), (oldQuantity + addQuantity));
    }
}
