package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.FruitTransaction.Operation;
import service.FruitTransactionService;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANITY = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> parseFruitTransactions(List<String> inputData) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String inputString : inputData) {
            if (inputString.startsWith("b") || inputString.startsWith("s")
                    || inputString.startsWith("r") || inputString.startsWith("p")) {
                String[] parameters = inputString.split(SPLITTER);
                FruitTransaction fruitTransaction = new FruitTransaction();
                fruitTransaction.setFruitName(parameters[FRUIT_NAME]);
                fruitTransaction.setQuantity(Integer.parseInt(parameters[QUANITY]));
                String operationType = parameters[OPERATION_TYPE];
                if (operationType.equals(Operation.BALANCE.getOperation())) {
                    fruitTransaction.setOperation(Operation.BALANCE);
                }
                if (operationType.equals(Operation.SUPPLY.getOperation())) {
                    fruitTransaction.setOperation(Operation.SUPPLY);
                }
                if (operationType.equals(Operation.PURCHASE.getOperation())) {
                    fruitTransaction.setOperation(Operation.PURCHASE);
                }
                if (operationType.equals(Operation.RETURN.getOperation())) {
                    fruitTransaction.setOperation(Operation.RETURN);
                }
                fruitTransactionList.add(fruitTransaction);
            }
        }
        return fruitTransactionList;
    }
}
