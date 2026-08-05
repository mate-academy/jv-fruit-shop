package core.basesyntax.strategy;

public class TransactionHandler {
    private final OperationStrategy operationStrategy;

    public TransactionHandler(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void process(String data) {
        String[] parts = data.split(",");
        String operation = parts[0];
        String fruitName = parts[1];
        int amount = Integer.parseInt(parts[2]);

        operationStrategy.get(operation).process(fruitName, amount);
    }
}
