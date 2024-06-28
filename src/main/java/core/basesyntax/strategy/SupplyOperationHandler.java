package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Optional;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new IllegalArgumentException("FruitTransaction cannot be null");
        }
        String fruit = fruitTransaction.getFruit();
        if (fruit == null || fruit.isEmpty()) {
            throw new IllegalArgumentException("Fruit cannot be null or empty");
        }
        int suppliedAmount = fruitTransaction.getQuantity();
        if (suppliedAmount <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        Optional<Integer> currentBalance = Optional.ofNullable(Storage.fruitStorage
                .get(fruit)); //currentBalance=50 suppliedAmount = 20
        int balanceAfterSupply = currentBalance.orElse(0) + suppliedAmount;
        Storage.fruitStorage.put(fruit,balanceAfterSupply);

    }
}
