package impl.operation.operations;

import dao.AccountDao;
import dao.AccountDaoImpl;
import model.FruitTransaction;

public class BalanceHandlerImpl implements OperationHandler {
    private final AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void handleTransaction(FruitTransaction fruitTransaction) {
        accountDao.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
