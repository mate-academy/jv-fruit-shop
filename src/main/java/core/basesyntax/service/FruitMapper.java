package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitMapper {
    private static final int FIRST_LINE = 0;
    private static final String COMMA = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    public List<FruitTransaction> mapData(List<String> lines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        lines.remove(FIRST_LINE);
        for (String line : lines) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] elements = line.split(COMMA);
            fruitTransaction.setOperation(
                    FruitTransaction.Operation.findOperationByCode(elements[OPERATION]));
            fruitTransaction.setFruit(elements[FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(elements[QUANTITY]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}

