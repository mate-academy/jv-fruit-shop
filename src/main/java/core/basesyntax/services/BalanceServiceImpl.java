package core.basesyntax.services;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionHandler;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;
import java.util.Map;

public class BalanceServiceImpl implements BalanceService {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void balance(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction: transactions) {
            TransactionStrategy strategy = new TransactionStrategy();
            TransactionHandler transactionHandler =
                    strategy.getTransactionService(transaction.getOperation());
            for (Map.Entry<String, Integer> entry: storageDao.get().entrySet()) {
                if (entry.getKey().equals(transaction.getFruit())) {
                    transactionHandler.updateFruitQuantity(transaction, entry.getValue());
                }
            }
        }
    }
}
