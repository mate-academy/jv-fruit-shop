package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(final Map<Operation, OperationHandler> operations) {
        this.operationStrategy = new OperationStrategyImpl(operations);
    }

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        stringBuilder.append(System.lineSeparator());
        Storage.storage.forEach((key, value) -> stringBuilder
                .append(key)
                .append(",")
                .append(value)
                .append(System.lineSeparator()));
        return stringBuilder.toString();
    }

    @Override
    public void addToStorage(final List<String> data) {
        data
                .stream()
                .skip(1)
                .forEach(e -> {
                    FruitTransaction transaction = getTransaction(e);
                    operationStrategy.get(transaction.getOperation()).handle(transaction);
                });
    }

    private FruitTransaction getTransaction(String line) {
        if (line != null) {
            final String[] data = line.split(",");
            Operation operation = Operation.get(data[OPERATION_INDEX]);
            Fruit fruit = new Fruit(data[FRUIT_INDEX]);
            int quantity = Integer.parseInt(data[QUANTITY_INDEX]);
            return new FruitTransaction(operation, fruit, quantity);
        }
        throw new RuntimeException("Line is null.");
    }
}
