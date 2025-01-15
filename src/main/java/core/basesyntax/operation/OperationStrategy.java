package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public interface OperationStrategy {
    void process(FruitTransaction transaction, Storage storage);
}
