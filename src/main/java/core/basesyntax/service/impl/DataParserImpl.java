package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {
    private static final String SEPARATOR = ",";
    private static final int INFORMATION_LINE_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        if( lines == null || lines.isEmpty()) {
            return new ArrayList<>();
        }
        lines.remove(INFORMATION_LINE_INDEX);
        List<FruitTransaction> transactions = new ArrayList<>();
        lines = removeSpaces(lines);
        for (String line : lines) {
            transactions.add(parseFruitTransaction(line));
        }
        return transactions;
    }

    private FruitTransaction parseFruitTransaction(String line) {
        String[] elements = line.split(SEPARATOR);
        if (elements.length != 3) {
            throw new RuntimeException("Invalid fruit transaction line: " + line);
        }
        FruitTransaction.Operation operation =
                FruitTransaction.Operation.fromCode(elements[OPERATION_INDEX]);
        String name = elements[FRUIT_NAME_INDEX];
        int quantity = Integer.parseInt(elements[FRUIT_QUANTITY_INDEX]);
        return new FruitTransaction(name, quantity, operation);
    }

    private List<String> removeSpaces(List<String> lines) {
        lines.replaceAll(str -> str.replace(" ", ""));
        return lines;
    }
}
