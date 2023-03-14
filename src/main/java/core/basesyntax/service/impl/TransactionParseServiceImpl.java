package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParseService;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParseServiceImpl implements TransactionParseService {
    public static final int FIRST_LINE_INDEX = 0;
    public static final String DEFAULT_FIRST_LINE = "type,fruit,quantity";
    public static final int TYPE_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    public static final String COMMA_SEPARATOR = ",";

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
        return lines.stream().anyMatch(l -> l.equals(DEFAULT_FIRST_LINE));
    }

    private FruitTransaction rowToFruitTransaction(String line) {
        String[] row = line.split(COMMA_SEPARATOR);
        return new FruitTransaction(
                FruitTransaction.Operation.getByCode(row[TYPE_INDEX]),
                row[FRUIT_INDEX],
                Integer.parseInt(row[QUANTITY_INDEX]));
    }
}
