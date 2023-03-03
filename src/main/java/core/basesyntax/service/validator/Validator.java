package core.basesyntax.service.validator;

import core.basesyntax.model.FruitTransaction;

public interface Validator {
    boolean validateFruitTransaction(FruitTransaction fruitTransaction);

    boolean checkFileName(String fileName);

    boolean checkTransaction(String operation, String fruit, String quantity);
}
