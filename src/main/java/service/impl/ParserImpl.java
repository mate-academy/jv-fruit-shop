package service.impl;

import java.util.ArrayList;
import java.util.List;
import service.Parser;

public class ParserImpl implements Parser {
    private static final int SERVICE_LINE = 0;
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
        rawData.remove(SERVICE_LINE);
        for (String line : rawData) {
            String[] parts = line.split(COMMA);
            transactions.add(new FruitTransaction(FruitTransaction
                    .Operation.getOperation(parts[OPERATION_CODE]),
                    parts[FRUIT_TYPE], Integer.parseInt(parts[FRUIT_QTY])));
        }
        return transactions;
    }
}

