package service.impl;

import core.basesyntax.FruitTransaction;
import java.util.ArrayList;
import java.util.List;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    public static final String COMMA = ",";
    public static final int OPERATION_ID = 0;
    public static final int FRUIT_ID = 1;
    public static final int QUANTITY_ID = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new RuntimeException("List 'lines' can't be empty or null");
        }
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            fruitTransactions.add(parseLine(lines.get(i)));
        }
        return fruitTransactions;
    }

    private FruitTransaction parseLine(String line) {
        String[] splitLine = line.trim().split(COMMA);
        return new FruitTransaction(FruitTransaction.Operation.fromCode(splitLine[OPERATION_ID]),
                splitLine[FRUIT_ID],
                Integer.parseInt(splitLine[QUANTITY_ID]));
    }
}
