package core.basesyntax.service.impl;

import core.basesyntax.exceptions.FruitTransactionException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParserService;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserServiceImpl implements FruitTransactionParserService {
    private static final String COMMA = ",";
    private static final String TRANSACTION_REGEX = "\\w,\\w+,\\d+";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> stringToFruitTransactions(List<String> strings) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String transaction : strings) {
            if (transaction.matches(TRANSACTION_REGEX)) {
                FruitTransaction fruitTransaction = getFruitTransaction(transaction);
                fruitTransactions.add(fruitTransaction);
            } else {
                throw new FruitTransactionException("Transaction: " + transaction
                        + " is not valid, must match: " + TRANSACTION_REGEX);
            }
        }
        return fruitTransactions;
    }

    private FruitTransaction getFruitTransaction(String transaction) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] transactionValues = transaction.split(COMMA);
        String operationValue = transactionValues[INDEX_OF_OPERATION];
        fruitTransaction.setOperation(
                FruitTransaction.Operation.getOperation(operationValue));
        fruitTransaction.setFruit(transactionValues[INDEX_OF_FRUIT]);
        int quantity = Integer.parseInt(transactionValues[INDEX_OF_QUANTITY]);
        fruitTransaction.setQuantity(quantity);
        return fruitTransaction;
    }
}
