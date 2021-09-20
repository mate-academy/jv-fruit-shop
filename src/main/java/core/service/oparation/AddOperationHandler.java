package core.service.oparation;

import core.controller.FruitShop;
import core.model.Fruit;
import core.model.FruitRecordDto;

public class AddOperationHandler implements OperationHandler {

    @Override
    public void apply(FruitRecordDto fruitRecordDto) {
        String nameFruit = fruitRecordDto.getFruitName();
        Fruit fruit = new Fruit(nameFruit);
        int addQuantity = fruitRecordDto.getQuantity();
        int oldQuantity = FruitShop.STORAGE.getFruitStorageMap().get(fruit);
        FruitShop.STORAGE.getFruitStorageMap()
                .put(new Fruit(nameFruit), (oldQuantity + addQuantity));
    }
}
