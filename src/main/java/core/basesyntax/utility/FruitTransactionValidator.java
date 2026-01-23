package core.basesyntax.utility;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionValidator {
    ValidateData validate(Storage storage, FruitTransaction fruitTransaction);
}
