package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConvertor;
import java.util.ArrayList;
import java.util.List;

public class DataConvertorImpl implements DataConvertor {
    public static final int MINIMUM_SIZE = 2;
    public static final String CHAR_FOR_SPLIT = ",";

    @Override
    public List<FruitTransaction> dataConvert(List<String> allLines) {
        if (allLines.size() < MINIMUM_SIZE) {
            throw new RuntimeException("Empty lines");
        }
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < allLines.size(); i++) {
            String[] parts = allLines.get(i).split(CHAR_FOR_SPLIT);
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid line: " + allLines.get(i));
            }
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(parts[0]));
            fruitTransaction.setFruit(parts[1]);
            fruitTransaction.setQuantity(Integer.parseInt(parts[2]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
