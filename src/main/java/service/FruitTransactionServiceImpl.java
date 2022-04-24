package service;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int SET_OPERATION = 0;
    private static final int SET_FRUIT_NAME = 1;
    private static final int SET_FRUIT_QUANTITY = 2;

    @Override
    public List<FruitTransaction> getFruitsTransactions(List<String[]> data) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String[] line : data) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(line[SET_OPERATION]);
            fruitTransaction.setFruitName(line[SET_FRUIT_NAME]);
            fruitTransaction.setQuantity(Integer.parseInt(line[SET_FRUIT_QUANTITY]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
