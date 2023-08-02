package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> processData(List<FruitTransaction> transactions) {
        addTransactionsToDatabase(transactions);
        return getDataFromDatabase();
    }

    private void addTransactionsToDatabase(List<FruitTransaction> transactions) {
        transactions.forEach(transaction -> operationStrategy
                .getOperation(transaction.getOperation())
                .executeOperation(transaction));
    }

    private Map<String, Integer> getDataFromDatabase() {
        return Storage.STORAGE;
    }
}
