package service;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;

public class FruitTransactionServiceImpl implements FruitTransactionService {

    @Override
    public List<FruitTransaction> getFruitsTransactionsList(List<String[]> fruitsInputDataList) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        FruitTransaction newFruitTransaction;
        for (String[] strings : fruitsInputDataList) {
            newFruitTransaction = new FruitTransaction();
            newFruitTransaction.setOperation(strings[0]);
            newFruitTransaction.setFruitName(strings[1]);
            newFruitTransaction.setQuantity(Integer.parseInt(strings[2]));
            fruitTransactionList.add(newFruitTransaction);
        }
        return fruitTransactionList;
    }
}
