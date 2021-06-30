package core.basesyntax.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handlers.FruitOperationHandler;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dtos.FruitDtoTransaction;
import core.basesyntax.services.impl.DataValidatorImpl;
import core.basesyntax.services.interfaces.DataValidator;
import java.util.Optional;

public class RemoveOperation implements FruitOperationHandler {

    @Override
    public int apply(FruitDtoTransaction fruitDtoTransaction) {
        Fruit fruit = new Fruit(fruitDtoTransaction.getFruitName());
        int currentQuantity = Optional.ofNullable(Storage.getFruits().get(fruit)).orElse(0);
        int operationQuantity = fruitDtoTransaction.getFruitCount();
        DataValidator dataValidator = new DataValidatorImpl();
        dataValidator.checkIfQuantitySufficiently(currentQuantity, operationQuantity);
        Storage.getFruits().put(fruit, currentQuantity - operationQuantity);
        return currentQuantity - operationQuantity;
    }
}
