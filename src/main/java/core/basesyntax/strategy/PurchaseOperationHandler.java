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

        Integer currentBalance = Optional.ofNullable(Storage.fruitStorage.get(fruit)).orElse(0);
        int balanceAfterPurchase = currentBalance - amountToPurchase;

        if (balanceAfterPurchase < 0) {
            throw new RuntimeException("Insufficient stock for item " + fruit);
        }
        Storage.fruitStorage.put(fruit, balanceAfterPurchase);
    }
}
