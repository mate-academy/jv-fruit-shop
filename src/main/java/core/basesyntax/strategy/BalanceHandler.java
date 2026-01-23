package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.utility.FruitTransactionValidator;
import core.basesyntax.utility.ValidateData;

public class BalanceHandler implements OperationHandler {
    private final FruitTransactionValidator validator;

    public BalanceHandler(FruitTransactionValidator validator) {
        if (validator == null) {
            throw new IllegalArgumentException("Validator can't be null");
        }
        this.validator = validator;
    }

    @Override
    public void handle(Storage storage, FruitTransaction fruitTransaction) {
        ValidateData data = validator.validate(storage, fruitTransaction);
        storage.putQuantity(data.getFruit(), data.getQuantity());
    }
}
