package core.basesyntax.service.strategy;

import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer getQuantity(int transactionQuantity,
                               String fruitName,
                               Map<String, Integer> dayReport) {
        return transactionQuantity;
    }
}
