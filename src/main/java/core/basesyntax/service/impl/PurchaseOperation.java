package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;
import java.util.Optional;

public class PurchaseOperation implements FruitOperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        Optional<Integer> optional = Optional.ofNullable(Storage.fruits.get(fruit));
        Integer currentQuantity = optional.get();
        int purchaseAmount = fruitRecordDto.getQuantity();
        if (purchaseAmount > currentQuantity) {
            throw new RuntimeException("Buyers will not be able to buy "
                    + purchaseAmount + "unit(s) of this fruit, because they are only"
                    + currentQuantity + " units in stock");
        }
        if (purchaseAmount < 0) {
            throw new RuntimeException("Buyers will not be able to buy "
                    + purchaseAmount + "unit(s) of this fruit. It's incorrect input.");
        }
        int newQuantity = currentQuantity - purchaseAmount;
        Storage.fruits.put(fruit, newQuantity);
        return newQuantity;
    }

    @Override
    public String getOperationType() {
        return "p";
    }
}
