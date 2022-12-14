package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseAll(List<String> stringList) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String fruitTransactions: stringList) {
            String[] split = fruitTransactions.split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setFruit(split[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(split[QUANTITY_INDEX]));
            fruitTransaction.setOperation(getOperation(split[OPERATION_INDEX]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }

    private FruitTransaction.Operation getOperation(String code) {
        for (FruitTransaction.Operation operation: FruitTransaction.Operation.values()) {
            if (operation.getOperation().equals(code)) {
                return operation;
            }
        }
        throw new RuntimeException("No such element found");
    }
}
