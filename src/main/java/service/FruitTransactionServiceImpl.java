package service;

import dao.FruitTransactionDao;
import java.util.List;
import model.FruitTransaction;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private final FruitTransactionDao fruitTransactionDao;

    public FruitTransactionServiceImpl(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void createNewFruitTransaction(List<String[]> fruitsInputDataList) {
        FruitTransaction newFruitTransaction;
        for (String[] strings : fruitsInputDataList) {
            newFruitTransaction = new FruitTransaction();
            newFruitTransaction.setOperation(strings[0]);
            newFruitTransaction.setFruitName(strings[1]);
            newFruitTransaction.setQuantity(Integer.parseInt(strings[2]));
            fruitTransactionDao.add(newFruitTransaction);
        }
    }
}
