package service.impl;

import db.Storage;
import db.StorageImpl;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitService;
import strategy.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private static final Storage storage = new StorageImpl();
    private static final int PRIMARY_QUANTITY = 0;
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        String data = transactions.stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit,
                        Collectors.summingInt(line -> operationStrategy.get(line.getOperation())
                                .executionOfOperation(line.getQuantity(), PRIMARY_QUANTITY))))
                .toString();

        storage.transferToStorage(data);

    }
}
