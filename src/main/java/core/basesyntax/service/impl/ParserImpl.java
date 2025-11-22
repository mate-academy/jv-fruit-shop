package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final String COMA = ",";
    private static final int OPERATION_POS = 0;
    private static final int FRUIT_POS = 1;
    private static final int QUANTITY_POS = 2;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data cannot be null or empty!");
        }
        for (int i = 1; i < data.size(); i++) {
            fruitTransactionList.add(parseLine(data.get(i)));
        }
        return fruitTransactionList;
    }

    private FruitTransaction parseLine(String line) {
        String[] split = line.trim().split(COMA);
        return new FruitTransaction(FruitTransaction.Operation.fromCode(split[OPERATION_POS]),
                split[FRUIT_POS],
                Integer.parseInt(split[QUANTITY_POS]));
    }
}
