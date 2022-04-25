package service;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getFruitsTransactions(List<String[]> data) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String[] line : data) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(line[OPERATION_INDEX]);
            fruitTransaction.setFruitName(line[FRUIT_NAME_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(line[FRUIT_QUANTITY_INDEX]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
