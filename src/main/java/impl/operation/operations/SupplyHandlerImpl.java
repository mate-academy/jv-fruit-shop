package impl.operation.operations;

import dao.AccountDao;
import dao.AccountDaoImpl;
import model.FruitTransaction;

public class SupplyHandlerImpl implements OperationHandler {
    private final AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void handleTransaction(FruitTransaction fruitTransaction) {
        Integer fruitQuantity = accountDao.getAmountByFruit(fruitTransaction.getFruit());
        Integer newFruitQuantity = fruitQuantity + fruitTransaction.getQuantity();
        accountDao.put(fruitTransaction.getFruit(), newFruitQuantity);
    }
}
