package core.service.oparation;

import core.model.Fruit;
import core.model.FruitRecordDto;
import core.model.Storage;

public class PurchaseHandler implements OperationHandler {

    @Override
    public void apply(FruitRecordDto fruitRecordDto) {
        String nameFruit = fruitRecordDto.getFruitName();
        Fruit fruit = new Fruit(nameFruit);
        int subtractQuantity = fruitRecordDto.getQuantity();
        int oldQuantity = Storage.getFruitStorageMap().get(new Fruit(nameFruit));
        if (subtractQuantity <= Storage.getFruitStorageMap().get(fruit)) {
            Storage.getFruitStorageMap()
                    .put(new Fruit(nameFruit), (oldQuantity - subtractQuantity));
        } else {
            throw new RuntimeException("It isn't enough " + fruit.getName() + "!");
        }
    }
}
