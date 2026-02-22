package core.basesyntax.strategy.handler.impl;

import core.basesyntax.strategy.handler.OperationHandler;
import java.math.BigDecimal;

public class PurchaseOperation implements OperationHandler {
    @Override
    public String apply(BigDecimal initialQuantity, BigDecimal quantity) {
        validateInputs(initialQuantity, quantity);
        if (initialQuantity.subtract(quantity).compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial quantity cannot be less than quantity");
        }
        return initialQuantity.subtract(quantity).toString();
    }
}
