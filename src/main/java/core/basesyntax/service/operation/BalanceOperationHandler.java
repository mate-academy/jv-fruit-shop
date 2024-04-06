package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.validator.QuantityValidator;

public class BalanceOperationHandler implements OperationHandler {
    private final QuantityValidator quantityValidator = new QuantityValidator();

    @Override
    public void getTransaction(FruitTransaction fruitTransaction) {
        quantityValidator.getQuantityValidation(fruitTransaction.getQuantity());
        Storage.remainsOfFruits.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
