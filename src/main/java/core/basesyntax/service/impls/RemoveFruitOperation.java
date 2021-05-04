package core.basesyntax.service.impls;

import core.basesyntax.db.Storage;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.DatabaseOperation;

public class RemoveFruitOperation implements DatabaseOperation {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        int newQuantity = Storage.shopDatabase.get(fruitRecordDto.getFruitName())
                - fruitRecordDto.getQuantity();
        Storage.shopDatabase.put(fruitRecordDto.getFruitName(), newQuantity);
        return newQuantity;
    }
}
