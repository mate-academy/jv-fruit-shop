package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public interface OperationCodeParser {
    void process(FruitTransaction transaction, FruitStorage storage);
}

