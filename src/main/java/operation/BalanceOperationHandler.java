package operation;

import dao.FruitTransactionDao;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitTransactionDao fruitTransactionDao;

    public BalanceOperationHandler(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public Integer applyNewAmount(String fruitName,Integer newFruitAmount) {
        Integer balanceFromStorage = fruitTransactionDao.getFromStorage(fruitName);
        Integer newBalanceToStorage = balanceFromStorage + newFruitAmount;
        fruitTransactionDao.addToStorage(fruitName,newBalanceToStorage);
        return newBalanceToStorage;
    }
}
