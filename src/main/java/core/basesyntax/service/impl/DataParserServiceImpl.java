package core.basesyntax.service.impl;

import static core.basesyntax.model.FruitTransaction.Operation.parseOperation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import java.util.ArrayList;
import java.util.List;

public class DataParserServiceImpl implements DataParserService {
    private static final String SPLIT_SYMBOL = ",";
    private static final int MAX_PARTS = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            transactions.add(processLine(line));
        }
        return transactions;
    }

    private FruitTransaction processLine(String line) {
        String[] parts = line.split(SPLIT_SYMBOL);
        if (parts.length != MAX_PARTS) {
            throw new IllegalArgumentException("Invalid line format: " + line);
        }
        FruitTransaction.Operation operation = parseOperation(parts[OPERATION_INDEX].trim());
        String fruit = parts[FRUIT_INDEX].trim();
        int quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());
        return new FruitTransaction(operation, fruit, quantity);
    }
}
