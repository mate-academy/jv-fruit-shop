package core.basesyntax.service.impls;

import core.basesyntax.db.Storage;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.DatabaseOperation;

public class AddFruitOperation implements DatabaseOperation {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        int currentQuantity = Storage.shopDatabase.get(fruitRecordDto.getFruitName()) == null
                ? 0 : Storage.shopDatabase.get(fruitRecordDto.getFruitName());
        int newQuantity = currentQuantity + fruitRecordDto.getQuantity();
        validate(fruitRecordDto.getQuantity(), newQuantity);
        Storage.shopDatabase.put(fruitRecordDto.getFruitName(), newQuantity);
        return newQuantity;
    }
}
