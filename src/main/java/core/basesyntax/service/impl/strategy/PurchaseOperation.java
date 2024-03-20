package core.basesyntax.service.impl.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.InvalidQuantityException;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransactionDto fruitTransactionDto) {
        String fruit = fruitTransactionDto.fruit();
        Integer quantity = Storage.fruitStorage.get(fruit);
        Integer neededQuantity = fruitTransactionDto.quantity();

        if (neededQuantity > quantity) {
            throw new InvalidQuantityException("Not enough " + fruit + "s" + " in storage, "
                    + "(now " + quantity + ", required - " + neededQuantity
                    + ") - can't do this operation");
        }
        Storage.fruitStorage.put(fruit, quantity - neededQuantity);
    }
}
