package core.basesyntax.service.operation;

import core.basesyntax.domain.Fruit;

import java.math.BigDecimal;

public class BalanceOperation implements OperationHandler {

    @Override
    public int getQuantity(int defaultQuantity, int fruitQuantity) {
        return defaultQuantity + fruitQuantity;
    }
}
