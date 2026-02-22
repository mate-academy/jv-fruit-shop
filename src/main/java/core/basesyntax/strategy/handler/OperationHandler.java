package core.basesyntax.strategy.handler;

import java.math.BigDecimal;

public interface OperationHandler {
    String apply(BigDecimal initialQuantity, BigDecimal quantity);

    default void validateInputs(BigDecimal initialQuantity, BigDecimal quantity) {
        if (initialQuantity == null || quantity == null) {
            throw new IllegalArgumentException("Initial quantity or quantity cannot be null");
        }
        if (quantity.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
    }
}
