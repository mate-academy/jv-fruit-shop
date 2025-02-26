package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA_SEPARATOR = ",";
    private static final int EXPECTED_COLUMNS = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int HEADER_ROW_INDEX = 0;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> transactionFile) {
        return IntStream.range(1, transactionFile.size())
                .mapToObj(index -> new Object[]{index
                        + 1, transactionFile.get(index)})
                .filter(entry -> !entry[1].toString().isBlank())
                .map(entry -> {
                    int lineNumber = (int) entry[0];
                    String csvLine = entry[1].toString();
                    String[] fields = csvLine.split(COMMA_SEPARATOR);
                    fields = trimFields(fields);

                    if (fields.length != EXPECTED_COLUMNS) {
                        throw new IllegalArgumentException("Invalid CSV row format at line "
                                + lineNumber + ": " + csvLine);
                    }
                    return new Object[]{lineNumber, fields};
                })
                .map(entry -> {
                    int lineNumber = (int) entry[0];
                    String[] fields = (String[]) entry[1];

                    try {
                        FruitTransaction.Operation operation = FruitTransaction.Operation
                                .fromCode(fields[OPERATION_INDEX]);
                        String fruitName = fields[FRUIT_INDEX];
                        int quantity = Integer.parseInt(fields[QUANTITY_INDEX]);

                        return new FruitTransaction(operation, fruitName, quantity);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid number format at line "
                                + lineNumber + ": " + fields[QUANTITY_INDEX]);
                    }
                })
                .collect(Collectors.toList());
    }

    private String[] trimFields(String[] fields) {
        return Arrays.stream(fields)
                .map(String::trim)
                .toArray(String[]::new);
    }
}
