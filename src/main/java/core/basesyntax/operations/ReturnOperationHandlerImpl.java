package core.basesyntax.operations;

import core.basesyntax.model.Fruit;
import java.math.BigDecimal;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public BigDecimal perform(Fruit fruit, BigDecimal operationQuantity) {
        return fruit.getQuantity().add(operationQuantity);
    }
}
