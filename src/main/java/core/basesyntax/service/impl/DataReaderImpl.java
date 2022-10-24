package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataReaderImpl implements DataReader {
    private static final String CSV_SPLITTER = ",";
    private static final int HEADER_ROW_INDEX = 0;
    private static final int TYPE_COLUMN_INDEX = 0;
    private static final int FRUIT_COLUMN_INDEX = 1;
    private static final int QUANTITY_COLUMN_INDEX = 2;

    @Override
    public List<FruitTransaction> readData(String path) {
        return parseRows(readLines(Path.of(path)));
    }

    private List<String> readLines(Path path) {
        List<String> rows;
        try {
            rows = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + path);
        }
        return rows;
    }

    private List<FruitTransaction> parseRows(List<String> rows) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        rows.remove(HEADER_ROW_INDEX);
        for (String row : rows) {
            String[] columns = row.split(CSV_SPLITTER);
            fruitTransactions.add(new FruitTransaction(
                    FruitTransaction.Operation.getOperationById(columns[TYPE_COLUMN_INDEX]),
                    columns[FRUIT_COLUMN_INDEX],
                    Integer.parseInt(columns[QUANTITY_COLUMN_INDEX])
            ));
        }
        return fruitTransactions;
    }
}
