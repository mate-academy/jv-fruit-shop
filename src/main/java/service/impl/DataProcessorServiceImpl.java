package service.impl;

import db.Storage;
import model.FruitTransaction;
import operations.*;
import service.*;

import java.util.List;

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
                OperationHandler handler = operationStrategy.getOperationHandler(transaction.getOperation());
                if (handler != null) {
                    handler.execute(storage, transaction);
                } else {
                    throw new IllegalArgumentException("Unsupported operation: " + transaction.getOperation());
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

        FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(operationCode);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
