package core.basesyntax.service.operationtypes;

import core.basesyntax.db.Storage;

public class ReturnHandler implements OperationTypeHandler {

    @Override
    public void apply(String fruitName, int amount) {
        Integer amountOfFruit = Storage.fruits.get(fruitName);
        Storage.fruits.put(fruitName, amountOfFruit + amount);
    }
}
