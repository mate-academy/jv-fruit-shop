package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;
    private StorageDao storageDao;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (String fruit : getFruits(transactions)) {
            int sumOfOperationValues = transactions.stream()
                    .filter(transaction -> transaction
                            .getFruit().equalsIgnoreCase(fruit))
                    .map(transaction -> {
                        FruitTransaction.Operation operation = transaction
                                .getOperation();
                        OperationHandler operationHandler = operationStrategy
                                .get(operation);
                        return operationHandler.makeOperation(transaction
                                .getQuantity());
                    })
                    .mapToInt(in -> in)
                    .sum();
            if (sumOfOperationValues < 0) {
                throw new RuntimeException("The resulting balance of "
                        + fruit + " is negative");
            }
            storageDao.add(fruit, sumOfOperationValues);
        }
    }

    private List<String> getFruits(List<FruitTransaction> transactions) {
        return transactions.stream()
                .map(FruitTransaction::getFruit)
                .distinct()
                .toList();
    }
}
