package core.basesyntax.strategy;

import core.basesyntax.db.FruitDao;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    Integer executeOperation(FruitDao fruitDao, FruitTransaction fruitTransaction);
}
