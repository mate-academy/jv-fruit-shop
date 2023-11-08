package core.basesyntax.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handlers.FruitOperationHandler;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dtos.FruitDtoTransaction;
import java.util.Optional;

public class AddOperation implements FruitOperationHandler {

    @Override
    public int apply(FruitDtoTransaction fruitDtoTransaction) {
        Fruit fruit = new Fruit(fruitDtoTransaction.getFruitName());
        int currentQuantity = Optional.ofNullable(Storage.getFruits().get(fruit)).orElse(0);
        int newQuantity = currentQuantity + fruitDtoTransaction.getFruitCount();
        Storage.getFruits().put(fruit, newQuantity);
        return newQuantity;
    }
}
