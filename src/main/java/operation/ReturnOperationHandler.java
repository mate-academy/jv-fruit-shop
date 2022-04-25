package operation;

import dao.FruitTransactionDao;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitTransactionDao fruitTransactionDao;

    public ReturnOperationHandler(FruitTransactionDao fruitTransactionDao) {
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
