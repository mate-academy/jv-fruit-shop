package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

import java.math.BigDecimal;

public class SupplyOperationHandler implements OperationHandler{

    @Override
    public int doCalculation(int amount) {
        return amount;
    }
}
