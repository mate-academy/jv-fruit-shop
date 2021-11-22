package core.basesyntax.strategy.operation;

import java.math.BigDecimal;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public BigDecimal getShopOperation(BigDecimal amount) {
        return amount.multiply(new BigDecimal(-1));
    }
}
