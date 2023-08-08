package service.impl;

import db.Storage;
import java.util.List;
import model.FruitTransaction;
import operations.OperationHandler;
import service.DataProcessorService;
import service.OperationStrategy;
import service.TransactionDataParse;

public class DataProcessorServiceImpl implements DataProcessorService {
    private final Storage storage;
    private final OperationStrategy operationStrategy;

    public DataProcessorServiceImpl(Storage storage, OperationStrategy operationStrategy) {
        this.storage = storage;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<String> inputLines) {
        TransactionDataParse transactionDataParse = new TransactionDataParseImpl();
        for (String line : inputLines) {
            FruitTransaction transaction = transactionDataParse.parseTransaction(line);
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
}
