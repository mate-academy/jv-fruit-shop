package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int AMOUNT_INDEX = 2;
    public static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseTransaction(List<String> transaction) {
        List<FruitTransaction> newTransaction = new ArrayList<>();
        for (String string : transaction) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] splitTransaction = string.split(SEPARATOR);
            fruitTransaction.setOperation(FruitTransaction
                    .Operation.getOperationByCode(splitTransaction[OPERATION_INDEX]));
            fruitTransaction.setFruit(splitTransaction[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(splitTransaction[AMOUNT_INDEX]));
            newTransaction.add(fruitTransaction);
        }
        return newTransaction;
    }
}
