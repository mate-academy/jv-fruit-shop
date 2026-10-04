package core.basesyntax.stratagy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {

    void handle(FruitTransaction transaction);
}
