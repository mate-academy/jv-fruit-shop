package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Optional;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new IllegalArgumentException("FruitTransaction cannot be null");
        }
        String fruit = fruitTransaction.getFruit();
        if (fruit == null || fruit.isEmpty()) {
            throw new IllegalArgumentException("Fruit cannot be null or empty");
        }
        int amountToPurchase = fruitTransaction.getQuantity();
        if (amountToPurchase <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        Optional<Integer> currentBalance = Optional.ofNullable(Storage.fruitStorage.get(fruit));
        int balanceAfterPurchase = currentBalance.orElse(0) - amountToPurchase;
        if (balanceAfterPurchase != 0) {
            Storage.fruitStorage.put(fruit,balanceAfterPurchase);
        } else {
            throw new RuntimeException("Item " + fruit + " is out of stock");
        }
    }
}
