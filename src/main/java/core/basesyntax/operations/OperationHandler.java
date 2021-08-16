package core.basesyntax.operations;

import core.basesyntax.model.Fruit;
import java.math.BigDecimal;

public interface OperationHandler {
    BigDecimal perform(Fruit fruit, BigDecimal operationQuantity);
}
