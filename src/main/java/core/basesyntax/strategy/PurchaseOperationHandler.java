package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.serviceimpl.FruitTransactionValidatorImpl;
import java.util.Optional;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitTransactionValidatorImpl validator;

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        validator.validateOperation(fruitTransaction);
        String fruit = fruitTransaction.getFruit();
        validator.validateFruit(fruit);
        int amountToPurchase = fruitTransaction.getQuantity();
        validator.validateAmount(amountToPurchase, FruitTransaction.Operation.PURCHASE);

        Optional<Integer> currentBalance = Optional.ofNullable(Storage.fruitStorage.get(fruit));
        int balanceAfterPurchase = currentBalance.orElse(0) - amountToPurchase;

        if (balanceAfterPurchase < 0) {
            throw new RuntimeException("Insufficient stock for item " + fruit);
        }
        Storage.fruitStorage.put(fruit, balanceAfterPurchase);
    }
}
