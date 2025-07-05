package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConvertor;
import java.util.ArrayList;
import java.util.List;

public class DataConvertorImpl implements DataConvertor {
    private static final int MINIMUM_SIZE = 2;
    private static final String COMMA = ",";
    private static final int PART_1 = 0;
    private static final int PART_2 = 1;
    private static final int PART_3 = 2;

    @Override
    public List<FruitTransaction> dataConvert(List<String> allLines) {
        if (allLines.size() < MINIMUM_SIZE) {
            throw new RuntimeException("Empty lines");
        }
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < allLines.size(); i++) {
            String[] parts = allLines.get(i).split(COMMA);
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid line: " + allLines.get(i));
            }
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(parts[PART_1]));
            fruitTransaction.setFruit(parts[PART_2]);
            fruitTransaction.setQuantity(Integer.parseInt(parts[PART_3]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
