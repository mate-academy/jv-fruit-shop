package strategy.transactionhandlers;

import dao.FruitStorageDao;
import dao.FruitStorageDaoImpl;
import model.FruitTransaction;

public class PurchaseTransactionHandlerImpl implements TransactionHandler {
    private FruitStorageDao dao = new FruitStorageDaoImpl();

    @Override
    public void transaction(FruitTransaction transaction) {
        int oldQuantity = dao.get(transaction.getName());
        dao.add(transaction.getName(), oldQuantity
                - transaction.getQuantity());
    }
}
