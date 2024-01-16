package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import java.math.BigDecimal;

public class ReturnOperationProvider implements OperationProvider {
    @Override
    public BigDecimal getOperated(FruitTransaction fruitTransaction, BigDecimal amount) {
        return amount.add(new BigDecimal(fruitTransaction.quantity()));
    }
}
