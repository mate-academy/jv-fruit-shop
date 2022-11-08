package strategy.transactionhandlers;

import dao.FruitStorageDao;
import dao.FruitStorageDaoImpl;
import model.FruitTransaction;

public class BalanceTransactionHandlerImpl implements TransactionHandler {
    private FruitStorageDao dao = new FruitStorageDaoImpl();

    @Override
    public void transaction(FruitTransaction transaction) {
        dao.add(transaction.getName(), transaction.getQuantity());
    }
}
