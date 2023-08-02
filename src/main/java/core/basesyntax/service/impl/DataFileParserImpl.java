package core.basesyntax.service.impl;

import core.basesyntax.service.DataFileParser;
import java.util.ArrayList;
import java.util.List;

public class DataFileParserImpl implements DataFileParser {
    private static final int OPERATION_CODE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int FRUIT_QTY = 2;
    private static final String COMMA = ",";

    @Override
    public List<FruitTransaction> parse(List<String> rawData) {
        if (rawData.isEmpty()) {
            throw new RuntimeException("Input data is empty");
        }
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < rawData.size(); i++) {
            String[] parts = rawData.get(i).split(COMMA);
            transactions.add(new FruitTransaction(FruitTransaction
                    .Operation.getOperation(parts[OPERATION_CODE]),
                    parts[FRUIT_TYPE], Integer.parseInt(parts[FRUIT_QTY])));
        }
        return transactions;
    }
}
