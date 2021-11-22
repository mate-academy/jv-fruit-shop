package core.basesyntax.strategy.operation;

import java.math.BigDecimal;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public BigDecimal getShopOperation(BigDecimal amount) {
        return amount;
    }
}

