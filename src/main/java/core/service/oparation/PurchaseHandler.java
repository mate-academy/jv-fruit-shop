package core.service.oparation;

import core.controller.FruitShop;
import core.model.Fruit;
import core.model.FruitRecordDto;

public class PurchaseHandler implements OperationHandler {

    @Override
    public void apply(FruitRecordDto fruitRecordDto) {
        String nameFruit = fruitRecordDto.getFruitName();
        Fruit fruit = new Fruit(nameFruit);
        int subtractQuantity = fruitRecordDto.getQuantity();
        int oldQuantity = FruitShop.STORAGE.getFruitStorageMap().get(new Fruit(nameFruit));
        if (subtractQuantity <= FruitShop.STORAGE.getFruitStorageMap().get(fruit)) {
            FruitShop.STORAGE.getFruitStorageMap()
                    .put(new Fruit(nameFruit), (oldQuantity - subtractQuantity));
        } else {
            throw new RuntimeException("It isn't enough " + fruit.getName() + "!");
        }
    }
}
