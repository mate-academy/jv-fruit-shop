package core.basesyntax;

import java.util.Map;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(Map<String, Integer> report, String fruit, int quantity) {
        report.put(fruit, report.getOrDefault(fruit, 0) - quantity);
    }
}

