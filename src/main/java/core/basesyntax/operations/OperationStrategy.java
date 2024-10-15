package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public interface OperationStrategy {

    void execute(Storage storage, FruitTransaction transaction);
}
