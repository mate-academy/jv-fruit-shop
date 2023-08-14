package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationActivity;

public class ReturnOperationActivity implements OperationActivity {
    @Override
    public int getOperation(int balance, int amount) {
        return balance + amount;
    }
}
