package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.serviceimpl.FruitTransactionValidatorImpl;
import java.util.Optional;

public class SupplyOperationHandler implements OperationHandler {
    private FruitTransactionValidatorImpl validator;

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        validator.validateOperation(fruitTransaction);
        String fruit = fruitTransaction.getFruit();
        validator.validateFruit(fruit);
        int suppliedAmount = fruitTransaction.getQuantity();
        validator.validateAmount(suppliedAmount, FruitTransaction.Operation.SUPPLY);

        Optional<Integer> currentBalance = Optional.ofNullable(Storage.fruitStorage
                .get(fruit)); //currentBalance=50 suppliedAmount = 20
        int balanceAfterSupply = currentBalance.orElse(0) + suppliedAmount;
        Storage.fruitStorage.put(fruit, balanceAfterSupply);

    }
}
