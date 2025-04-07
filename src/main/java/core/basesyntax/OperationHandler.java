package core.basesyntax;

import model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
