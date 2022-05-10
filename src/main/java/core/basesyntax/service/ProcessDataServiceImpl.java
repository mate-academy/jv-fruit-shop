package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessDataServiceImpl implements ProcessDataService {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private String stringHeader = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> getFromCsvRow(List<String[]> rows) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        if (rows.isEmpty()) {
            throw new RuntimeException("The file is empty");
        }
        String[] lines = rows.get(0);
        StringBuilder stringBuilder = new StringBuilder();
        for (String element : lines) {
            stringBuilder.append(element).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String header = stringBuilder.toString();
        if (!header.equals(stringHeader)) {
            throw new RuntimeException("Incorrect header. "
                    + "Header must be equal to: 'type,fruit,quantity'");
        }
        for (int i = 1; i < rows.size(); i++) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            Object[] objectsInString = Arrays.stream(rows.get(i)).toArray();

            fruitTransaction.setOperation(FruitTransaction
                    .getOperation(String.valueOf(objectsInString[OPERATION])));
            fruitTransaction.setFruit(String.valueOf(objectsInString[FRUIT]));
            fruitTransaction.setQuantity(Integer
                    .parseInt(String.valueOf(objectsInString[QUANTITY])));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
