package core.basesyntax.service.implementations;

import java.util.ArrayList;
import java.util.List;

public class TransactionParser {
    private static final int OPERATION_FIELD = 0;
    private static final int FRUIT_NAME_FIELD = 1;
    private static final int FRUIT_QUANTITY_FIELD = 2;
    private List<String> activities;

    public TransactionParser(List<String> activities) {
        this.activities = activities;
    }

    public List<FruitTransaction> getTransactionFromCsv() {
        List<FruitTransaction> transactionList = new ArrayList<>();
        activities.remove(0);
        for (String lines : activities) {
            String[] fields = lines.split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(fields[OPERATION_FIELD]);
            fruitTransaction.setFruit(fields[FRUIT_NAME_FIELD]);
            fruitTransaction.setQuantity(Integer.parseInt(fields[FRUIT_QUANTITY_FIELD]));
            transactionList.add(fruitTransaction);
        }
        return transactionList;
    }
}
