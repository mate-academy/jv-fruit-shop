package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
    // b - balance, the remnants of fruits at the beginning of the working day - fruits.put
    // s - supply, means you are receiving new fruits from suppliers
    // p - purchase, means someone has bought some fruit
    // r - return, means someone who has bought the fruits now returns them back
}
