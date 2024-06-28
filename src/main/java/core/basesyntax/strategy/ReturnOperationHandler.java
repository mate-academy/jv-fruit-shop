package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Optional;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new IllegalArgumentException("FruitTransaction cannot be null");
        }
        String fruit = fruitTransaction.getFruit();
        if (fruit == null || fruit.isEmpty()) {
            throw new IllegalArgumentException("Fruit cannot be null or empty");
        }
        int amountToReturn = fruitTransaction.getQuantity();
        Optional<Integer> currentBalance = Optional.ofNullable(Storage.fruitStorage.get(fruit));
        int balanceAfterReturn = currentBalance.orElse(0) + amountToReturn;
        Storage.fruitStorage.put(fruit,balanceAfterReturn);
    }
}
