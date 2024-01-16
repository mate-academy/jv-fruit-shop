package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import java.math.BigDecimal;

public class PurchaseOperationProvider implements OperationProvider {
    @Override
    public BigDecimal getOperated(FruitTransaction fruitTransaction, BigDecimal amount) {
        return amount.subtract(new BigDecimal(fruitTransaction.quantity()));
    }
}
