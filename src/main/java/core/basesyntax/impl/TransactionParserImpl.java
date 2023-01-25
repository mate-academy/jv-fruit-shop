package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    public static final int OPERATION_TYPE = 0;
    public static final int FRUIT_TYPE = 1;
    public static final int FRUIT_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> transactions) {
        List<FruitTransaction> transactionList = new ArrayList<>();
        for (int i = 1; i < transactions.size(); i++) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] transactionsArray = transactions.get(i).split(",");
            for (int j = 0; j < transactionsArray.length; j++) {
                FruitTransaction.Operation operation
                        = fruitTransaction.getOperationValue(transactionsArray[OPERATION_TYPE]);
                fruitTransaction.setOperation(operation);
                fruitTransaction.setFruit(transactionsArray[FRUIT_TYPE]);
                fruitTransaction.setQuantity(Integer.parseInt(transactionsArray[FRUIT_QUANTITY]));
            }
            transactionList.add(fruitTransaction);
        }
        return transactionList;
    }
}
