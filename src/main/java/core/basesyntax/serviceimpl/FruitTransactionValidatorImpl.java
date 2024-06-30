package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionValidator;

public class FruitTransactionValidatorImpl implements FruitTransactionValidator<FruitTransaction,
        FruitTransaction.Operation> {
    @Override
    public void validateOperation(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new IllegalArgumentException("FruitTransaction cannot be null");
        }
    }

    @Override
    public void validateFruit(String fruit) {
        if (fruit == null || fruit.isEmpty()) {
            throw new IllegalArgumentException("Fruit cannot be null or empty");
        }
    }

    @Override
    public void validateAmount(int amount, FruitTransaction.Operation operationType) {
        if (operationType == FruitTransaction.Operation.RETURN) {
            if (amount < 0) {
                throw new IllegalArgumentException("Quantity to return cannot be negative");
            }
        }
        if (operationType == FruitTransaction.Operation.SUPPLY) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Quantity cannot be negative"
                        + " and must be greater than zero");
            }
        }
        if (operationType == FruitTransaction.Operation.PURCHASE) {
            if (amount < 0) {
                throw new IllegalArgumentException("Quantity cannot be negative");
            }
        }
    }
}
