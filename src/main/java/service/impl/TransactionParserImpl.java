package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    static final int OPERATION_TYPE = 0;
    static final int FRUIT_TYPE = 1;
    static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> transactions) {
        List<FruitTransaction> parsedFruitList = new ArrayList<>();
        for (int i = 1; i < transactions.size(); i++) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] transactionsArrays = transactions.get(i).split(";");
            for (int j = 0; j < transactionsArrays.length; j++) {
                FruitTransaction.Operation operationValue = fruitTransaction
                        .getOperationValue(transactionsArrays[OPERATION_TYPE]);
                fruitTransaction.setOperation(operationValue);
                fruitTransaction.setFruit(transactionsArrays[FRUIT_TYPE]);
                fruitTransaction.setQuantity(Integer.parseInt(transactionsArrays[QUANTITY]));
            }
            parsedFruitList.add(fruitTransaction);
        }
        return parsedFruitList;
    }
}
