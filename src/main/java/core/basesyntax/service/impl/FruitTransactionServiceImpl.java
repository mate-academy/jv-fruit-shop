package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.transactions.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private final OperationStrategy strategy;
    private final StorageDao storageDao = new StorageDaoImpl();

    public FruitTransactionServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Map<String, Integer> addOrUpdate(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> fruitsBalance = new HashMap<>();
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            calculateOperationForFruit(fruitsBalance, fruitTransaction);
        }
        storageDao.addAll(fruitsBalance);
        return fruitsBalance;
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
