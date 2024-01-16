package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import java.math.BigDecimal;

public interface OperationProvider {
    BigDecimal getOperated(FruitTransaction fruitTransaction, BigDecimal amount);
}

