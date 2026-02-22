package core.basesyntax.strategy.handler.impl;

import core.basesyntax.strategy.handler.OperationHandler;
import java.math.BigDecimal;

public class ReturnOperation implements OperationHandler {
    @Override
    public String apply(BigDecimal initialQuantity, BigDecimal quantity) {
        validateInputs(initialQuantity, quantity);
        return initialQuantity.add(quantity).toString();
    }
}
