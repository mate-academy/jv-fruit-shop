package core.basesyntax.service.handler;

import java.math.BigDecimal;

public class PurchaseOperation implements OperationHandler {
    @Override
    public BigDecimal handle(BigDecimal bigDecimalActivity) {
        return bigDecimalActivity.negate();
    }
}
