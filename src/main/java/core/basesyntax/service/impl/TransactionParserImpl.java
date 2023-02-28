package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final String COLUMNS_SEPARATOR = ",";
    private static final String TYPE_COLUMN_NAME = "type";
    private static final String FRUIT_COLUMN_NAME = "fruit";
    private static final String QUANTITY_COLUMN_NAME = "quantity";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String ONLY_NUMS_REGEX = "[0-9]+";
    private final Reader reader;

    public TransactionParserImpl() {
        this.reader = new ReaderImpl();
    }

    @Override
    public List<List<String>> parse(String data) {
        if (data == null) {
            throw new RuntimeException("Argument must not be null");
        }
        List<String> dataSplit = new ArrayList<>(List.of(data.split(System.lineSeparator())));
        if (!isColumnsValid(dataSplit.get(0))) {
            throw new RuntimeException("Invalid columns in input file");
        }
        dataSplit.remove(0);
        return dataSplit.stream()
                .map(l -> {
                    if (!isRowValid(l)) {
                        throw new RuntimeException("Invalid row: " + l);
                    }
                    return Arrays.stream(l.split(COLUMNS_SEPARATOR)).collect(Collectors.toList());
                })
                .collect(Collectors.toList());
    }

    private boolean isColumnsValid(String columns) {
        String[] columnsSplit = columns.split(COLUMNS_SEPARATOR);
        return columnsSplit.length == 3
                && Objects.equals(columnsSplit[TYPE_INDEX], TYPE_COLUMN_NAME)
                && Objects.equals(columnsSplit[FRUIT_INDEX], FRUIT_COLUMN_NAME)
                && Objects.equals(columnsSplit[QUANTITY_INDEX], QUANTITY_COLUMN_NAME);
    }

    private boolean isRowValid(String row) {
        String[] rowSplit = row.split(COLUMNS_SEPARATOR);
        return (rowSplit.length == 3)
                && rowSplit[2].matches(ONLY_NUMS_REGEX);
    }
}
