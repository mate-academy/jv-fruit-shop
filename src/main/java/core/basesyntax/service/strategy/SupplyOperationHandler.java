package core.basesyntax.service.strategy;

import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public Integer getQuantity(int transactionQuantity,
                               String fruitName,
                               Map<String, Integer> dayReport) {
        Integer currentQuantity = dayReport.get(fruitName);

        if (currentQuantity == null) {
            return transactionQuantity;
        }

        return currentQuantity + transactionQuantity;
    }
}
