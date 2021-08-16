package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int apply(FruitDto fruitDto) {
        Fruit fruitName = new Fruit(fruitDto.getName());
        int currentQuantity = Storage.storage.getOrDefault(fruitName, 0);
        int newQuantity = currentQuantity - fruitDto.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Not enough fruits in storage");
        }
        Storage.storage.put(fruitName, newQuantity);
        return newQuantity;
    }
}
