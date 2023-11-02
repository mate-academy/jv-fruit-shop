package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.transaction.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private final OperationStrategy strategy;
    private final FruitStorageDao storageDao;

    public FruitTransactionServiceImpl(FruitStorageDao storageDao, OperationStrategy strategy) {
        this.storageDao = storageDao;
        this.strategy = strategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> fruitsBalance = new HashMap<>();
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            calculateOperationForFruit(fruitsBalance, fruitTransaction);
        }
        storageDao.addAll(fruitsBalance);
    }

    private void calculateOperationForFruit(Map<String, Integer> fruitsBalance,
                                            FruitTransaction fruitTransaction) {
        OperationHandler operationHandler =
                strategy.get(fruitTransaction.getOperation());
        int quantity;
        int currentAmount = 0;
        if (fruitsBalance.containsKey(fruitTransaction.getFruit())) {
            currentAmount = fruitsBalance.get(fruitTransaction.getFruit());
        }
        quantity = operationHandler.countQuantity(
                currentAmount, fruitTransaction.getQuantity());
        fruitsBalance.put(fruitTransaction.getFruit(), quantity);
    }
}
