package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.impl.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ExecuteTransactionService;
import core.basesyntax.strategy.TransactionHandler;
import core.basesyntax.strategy.TransactionHandlerStrategy;
import java.util.List;

public class ExecuteTransactionServiceImpl implements ExecuteTransactionService {
    private FruitStorageDao dao;
    private TransactionHandlerStrategy strategy;

    {
        dao = new FruitStorageDaoImpl();
        strategy = new TransactionHandlerStrategy();
    }

    @Override
    public void executeTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            dao.addData(transaction.getFruit(),
                    getAmount(transaction.getOperation(), transaction.getQuantity()));
        }
    }

    private int getAmount(FruitTransaction.Operation operation, Integer quantity) {
        TransactionHandler handler = strategy.getAmountService(operation);
        return handler.getAmount(quantity);
    }
}
