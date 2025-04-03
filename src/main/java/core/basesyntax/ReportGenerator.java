package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportGenerator {

    private final Map<Operation, OperationHandler> operationHandlers = new HashMap<>();

    public ReportGenerator() {
        operationHandlers.put(Operation.SUPPLY, new SupplyHandler());
        operationHandlers.put(Operation.PURCHASE, new PurchaseHandler());
        operationHandlers.put(Operation.RETURN, new ReturnHandler());
    }

    public String generateReport(List<FruitTransaction> transactions) {
        Map<String, Integer> report = new HashMap<>();

        for (FruitTransaction transaction : transactions) {
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();
            Operation operation = transaction.getOperation();

            OperationHandler handler = operationHandlers.get(operation);
            if (handler != null) {
                handler.handle(report, fruit, quantity);
            } else {
                System.out.println("Невідома операція: " + operation);
            }
        }

        StringBuilder reportOutput = new StringBuilder();
        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            reportOutput.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }

        return reportOutput.toString();
    }
}
