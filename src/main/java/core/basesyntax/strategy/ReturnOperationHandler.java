package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.serviceimpl.FruitTransactionValidatorImpl;
import java.util.Optional;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitTransactionValidatorImpl validator;

    public ReturnOperationHandler() {
        this.validator = new FruitTransactionValidatorImpl();
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        validator.validateOperation(fruitTransaction);
        String fruit = fruitTransaction.getFruit();
        validator.validateFruit(fruit);
        int amountToReturn = fruitTransaction.getQuantity();
        validator.validateAmount(amountToReturn, FruitTransaction.Operation.RETURN);

        Optional<Integer> currentBalance = Optional.ofNullable(Storage.fruitStorage.get(fruit));
        int balanceAfterReturn = currentBalance.orElse(0) + amountToReturn;
        Storage.fruitStorage.put(fruit, balanceAfterReturn);
    }
}
