package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.FruitTransaction.Operation;
import service.FruitTransactionService;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANITY_INDEX = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> parseFruitTransactions(List<String> inputData) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = 1; i < inputData.size(); i++) {
            String[] parameters = inputData.get(i).split(SPLITTER);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setFruitName(parameters[FRUIT_NAME_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(parameters[QUANITY_INDEX]));
            Operation operation = Operation.getOperation(parameters[OPERATION_TYPE_INDEX]);
            fruitTransaction.setOperation(operation);
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
