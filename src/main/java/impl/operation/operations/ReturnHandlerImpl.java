package impl.operation.operations;

import dao.AccountDao;
import dao.AccountDaoImpl;
import model.FruitTransaction;

public class ReturnHandlerImpl implements OperationHandler {
    private final AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void updateQuantity(FruitTransaction fruitTransaction) {
        Integer fruitQuantity = accountDao.getAmountByFruit(fruitTransaction.getFruit());
        Integer newFruitQuantity = fruitQuantity + fruitTransaction.getQuantity();
        accountDao.putInfoToStorage(fruitTransaction.getFruit(), newFruitQuantity);
    }
}
