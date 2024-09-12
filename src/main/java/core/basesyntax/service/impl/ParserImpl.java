package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    public static final String WORD_SEPARATOR = ",";
    private static final int MAX_FIELD_LENGTH = 3;
    private static final int CODE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        return data.stream()
                .filter(line ->
                        data.indexOf(line) != data.indexOf(data.get(CODE_INDEX)))
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(WORD_SEPARATOR);
        if (fields.length < MAX_FIELD_LENGTH) {
            throw new RuntimeException("Null value presents in line: " + line);
        }
        if (fields.length > MAX_FIELD_LENGTH) {
            throw new RuntimeException("Redundant value presents in line: " + line);
        }
        FruitTransaction fruitTransaction = new FruitTransaction();
        try {
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .getOperationFromLetter(fields[CODE_INDEX]);
            fruitTransaction.setOperation(operation);
            fruitTransaction.setFruit(fields[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid value presents in line: " + line);
        }
        return fruitTransaction;
    }
}
