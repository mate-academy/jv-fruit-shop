package core.basesyntax.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handlers.FruitOperationHandler;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dtos.FruitDtoTransaction;
import core.basesyntax.services.impl.DataValidatorImpl;
import core.basesyntax.services.interfaces.DataValidator;
import java.util.Optional;

public class AddOperation implements FruitOperationHandler {
    private static final int ZERO = 0;

    @Override
    public int apply(FruitDtoTransaction fruitDtoTransaction) {
        Fruit fruit = new Fruit(fruitDtoTransaction.getFruitName());
        int currentQuantity = Optional.ofNullable(Storage.getFruits().get(fruit)).orElse(ZERO);
        DataValidator dataValidator = new DataValidatorImpl();
        dataValidator.checkIfQuantityPositive(fruitDtoTransaction.getFruitCount());
        int newQuantity = currentQuantity + fruitDtoTransaction.getFruitCount();
        Storage.getFruits().put(fruit, newQuantity);
        return newQuantity;
    }
}
