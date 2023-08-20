package core.basesyntax.service.strategy;

import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Integer getQuantity(int transactionQuantity,
                               String fruitName,
                               Map<String, Integer> dayReport) {
        Integer currentQuantity = dayReport.get(fruitName);
        return currentQuantity - transactionQuantity;
    }
}
