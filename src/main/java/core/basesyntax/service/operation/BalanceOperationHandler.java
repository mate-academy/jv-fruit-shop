package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

import java.math.BigDecimal;

public class BalanceOperationHandler implements OperationHandler{

    @Override
    public int doCalculation(int amount) {
        return amount;
    }
}
