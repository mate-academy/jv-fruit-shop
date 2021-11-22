package core.basesyntax.strategy.operation;

import java.math.BigDecimal;

public interface OperationHandler {
    BigDecimal getShopOperation(BigDecimal amount);
}
