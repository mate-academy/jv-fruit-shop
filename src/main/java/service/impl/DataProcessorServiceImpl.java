package service.impl;

import db.Storage;
import java.util.List;
import model.FruitTransaction;
import operations.OperationHandler;
import service.DataProcesorService;
import service.OperationStrategy;

public class DataProcessorServiceImpl implements DataProcesorService {
    private final Storage storage;
    private final OperationStrategy operationStrategy;

    public DataProcessorServiceImpl(Storage storage, OperationStrategy operationStrategy) {
        this.storage = storage;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<String> inputLines) {
        for (String line : inputLines) {
            FruitTransaction transaction = parseTransaction(line);
            if (transaction != null) {
                OperationHandler handler = operationStrategy
                        .getOperationHandler(transaction.getOperation());
                if (handler != null) {
                    handler.execute(storage, transaction);
                } else {
                    throw new IllegalArgumentException("Unsupported operation: "
                        + transaction.getOperation());
                }
            }
        }
    }

    public FruitTransaction parseTransaction(String line) {
        String[] tokens = line.split(",");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Invalid transaction line: " + line);
        }

        String operationCode = tokens[0].trim();
        String fruit = tokens[1].trim();
        int quantity = Integer.parseInt(tokens[2].trim());
        if (quantity < 0) {
            throw new IllegalArgumentException("Invalid quantity value " + quantity);
        }
        FruitTransaction.Operation operation = FruitTransaction.Operation
                .fromCode(operationCode);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
