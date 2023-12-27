package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitTransactionService;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final String COMA = ",";
    private static final String BRACKETS = "\"";

    @Override
    public List<FruitTransaction> getFruitTransactionsFromData(List<String> activities) {
        List<FruitTransaction> allTransactions = new ArrayList<>();
        for (int i = 1; i < activities.size(); i++) {
            String activity = activities.get(i);
            activity = activity.replaceAll(BRACKETS, "");
            FruitTransaction fruitTransaction = createFruitTransaction(activity);
            allTransactions.add(fruitTransaction);
        }
        return allTransactions;
    }

    private FruitTransaction createFruitTransaction(String activity) {
        String[] row = activity.split(COMA);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(Operation
                .getOperationFromCode(row[INDEX_OF_OPERATION]));
        fruitTransaction.setFruit(new Fruit(row[INDEX_OF_FRUIT]));
        fruitTransaction.setQuantity(Integer.parseInt(row[INDEX_OF_QUANTITY]));
        return fruitTransaction;
    }
}
