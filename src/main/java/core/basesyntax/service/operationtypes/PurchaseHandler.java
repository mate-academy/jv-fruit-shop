package core.basesyntax.service.operationtypes;

import core.basesyntax.db.Storage;

public class PurchaseHandler implements OperationTypeHandler {

    @Override
    public void apply(String fruitName, int amount) {
        Integer amountOfFruit = Storage.fruits.get(fruitName);
        if (amountOfFruit - amount < 0) {
            throw new RuntimeException("Product out of stock");
        }
        Storage.fruits.put(fruitName, amountOfFruit - amount);

    }
}
