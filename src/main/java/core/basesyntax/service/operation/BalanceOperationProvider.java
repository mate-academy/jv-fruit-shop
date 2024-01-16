package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import java.math.BigDecimal;

public class BalanceOperationProvider implements OperationProvider {
    @Override
    public BigDecimal getOperated(FruitTransaction fruitTransaction, BigDecimal amount) {
        return new BigDecimal(fruitTransaction.quantity());
    }
}
