package core.service.oparation;

import core.model.Fruit;
import core.model.FruitRecordDto;
import core.model.Storage;

public class AddOperationHandler implements OperationHandler {

    @Override
    public void apply(FruitRecordDto fruitRecordDto) {
        String nameFruit = fruitRecordDto.getFruitName();
        Fruit fruit = new Fruit(nameFruit);
        int addQuantity = fruitRecordDto.getQuantity();
        int oldQuantity = Storage.getFruitStorageMap().get(fruit);
        Storage.getFruitStorageMap().put(new Fruit(nameFruit), (oldQuantity + addQuantity));
    }
}
