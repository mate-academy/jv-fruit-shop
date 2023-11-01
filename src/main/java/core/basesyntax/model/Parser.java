package core.basesyntax.model;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final String REGEX = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    public static List<FruitTransaction> parseListToTransactionList(List<String> fileData) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = 1; i < fileData.size(); i++) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] data = fileData.get(i).split(REGEX);
            fruitTransaction.setOperation(Operation.findByCode(data[OPERATION]));
            fruitTransaction.setFruit(data[FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(data[QUANTITY]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
