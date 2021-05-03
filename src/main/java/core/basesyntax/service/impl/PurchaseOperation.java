package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;

public class PurchaseOperation implements FruitOperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        Integer currentQuantity = Storage.fruits.get(fruit);
        int purchaseAmount = fruitRecordDto.getQuantity();
        if (purchaseAmount > currentQuantity) {
            throw new RuntimeException("Buyers will not be able to buy "
                    + purchaseAmount + " bananas, because they are only"
                    + currentQuantity + " units in stock");
        }
        if (purchaseAmount < 0) {
            throw new RuntimeException("Buyers will not be able to buy "
                    + purchaseAmount + " bananas. -10 is incorrect input.");
        }
        int newQuantity = currentQuantity - purchaseAmount;
        Storage.fruits.put(fruit,newQuantity);
        return newQuantity;
    }

    @Override
    public String getOperationType() {
        return "p";
    }
}
