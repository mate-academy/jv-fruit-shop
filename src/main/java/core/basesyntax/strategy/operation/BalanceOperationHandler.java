package core.basesyntax.strategy.operation;

import java.math.BigDecimal;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public BigDecimal getShopOperation(BigDecimal amount) {
        return amount;
    }
}
