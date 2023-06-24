package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParserService;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final int FIRST_LINE_INDEX = 0;
    private static final String DEFAULT_TITLE = "type,fruit,quantity";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new RuntimeException("Input list is null");
        }
        if (!isFirsRowValid(lines)) {
            throw new RuntimeException("Invalid names of columns");
        }
        lines.remove(FIRST_LINE_INDEX);
        return lines.stream()
                .map(this::rowToFruitTransaction)
                .collect(Collectors.toList());
    }

    private boolean isFirsRowValid(List<String> lines) {
        return lines.get(FIRST_LINE_INDEX).equals(DEFAULT_TITLE);
    }

    private FruitTransaction rowToFruitTransaction(String line) {
        String[] row = line.split(COMMA_SEPARATOR);
        return new FruitTransaction(
                FruitTransaction.Operation.getByCode(row[TYPE_INDEX]),
                row[FRUIT_INDEX],
                Integer.parseInt(row[QUANTITY_INDEX]));
    }
}
