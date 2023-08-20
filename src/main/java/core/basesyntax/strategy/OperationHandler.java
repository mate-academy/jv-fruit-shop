package core.basesyntax.strategy;

import java.math.BigDecimal;

public interface OperationHandler {
    void completeOperation(String fruitName, BigDecimal quantity);

}
