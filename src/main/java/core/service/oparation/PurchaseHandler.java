package core.service.oparation;

import core.controller.FruitShop;
import core.model.Fruit;
import java.util.Map;

public class PurchaseHandler implements OperationHandler {

    private static final int INDEX_NAME_FRUIT = 1;
    private static final int INDEX_QUANTITY_FRUIT = 2;

    @Override
    public void doOperation(Map<Fruit, Integer> fruitMap, String[] operation) {
        String nameFruit = operation[INDEX_NAME_FRUIT];
        Fruit fruit = new Fruit(nameFruit);
        int subtractQuantity = Integer.parseInt(operation[INDEX_QUANTITY_FRUIT]);
        int oldQuantity = FruitShop.STORAGE.getFruitStorageMap().get(new Fruit(nameFruit));
        if (subtractQuantity <= FruitShop.STORAGE.getFruitStorageMap().get(fruit)) {
            FruitShop.STORAGE.getFruitStorageMap()
                    .put(new Fruit(nameFruit), (oldQuantity - subtractQuantity));
        } else {
            throw new RuntimeException("It isn't enough " + fruit.getName() + "!");
        }
    }
}
