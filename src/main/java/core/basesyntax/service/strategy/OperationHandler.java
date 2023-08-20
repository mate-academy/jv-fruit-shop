package core.basesyntax.service.strategy;

import java.util.Map;

public interface OperationHandler {
    Integer getQuantity(int transactionQuantity, String fruitName, Map<String, Integer> dayReport);
}
