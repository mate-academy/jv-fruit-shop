package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.utility.FruitTransactionValidator;
import core.basesyntax.utility.ValidateData;

public class PurchaseHandler implements OperationHandler {
    private final FruitTransactionValidator validator;

    public PurchaseHandler(FruitTransactionValidator validator) {
        if (validator == null) {
            throw new IllegalArgumentException("Validator can't be null");
        }
        this.validator = validator;
    }

    @Override
    public void handle(Storage storage, FruitTransaction fruitTransaction) {
        ValidateData data = validator.validate(storage, fruitTransaction);
        int qtyFruit = storage.getQuantity(data.getFruit());
        if (qtyFruit < data.getQuantity()) {
            throw new IllegalArgumentException(
                    "Not enough items in storage for purchase of "
                            + data.getQuantity() + " "
                            + data.getFruit() + "(s)");
        }
        storage.putQuantity(
                data.getFruit(),
                qtyFruit - data.getQuantity());
    }
}
