package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int apply(FruitDto fruitDto) {
        Fruit fruitName = new Fruit(fruitDto.getName());
        int currentQuantity = Storage.storage.getOrDefault(fruitName, 0);
        int newQuantity = currentQuantity + fruitDto.getQuantity();
        Storage.storage.put(fruitName, newQuantity);
        return newQuantity;
    }
}
