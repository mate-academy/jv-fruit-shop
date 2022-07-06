package core.service.impl;

import core.service.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public int getSign() {
        return 1;
    }
}
