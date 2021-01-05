package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ValidateOperation;

public class ValidateOperationImpl implements ValidateOperation {
    @Override
    public void validate(Storage storage, Fruit fruit, int amount) {
        if (!storage.getStorage().containsKey(fruit)) {
            throw new RuntimeException("Incorrect operation!!! "
                    + "This fruit does not have a balance!");
        }
    }
}
