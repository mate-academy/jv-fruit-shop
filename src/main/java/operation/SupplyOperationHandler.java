package operation;

import dao.FruitTransactionDao;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitTransactionDao fruitTransactionDao;

    public SupplyOperationHandler(FruitTransactionDao fruitTransactionDao) {
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
