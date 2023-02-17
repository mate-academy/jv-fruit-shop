package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvTransactionsParser;
import java.util.List;
import java.util.stream.Collectors;

public class CsvTransactionsParserImpl implements CsvTransactionsParser {
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private static final int TITLE_POSITION = 1;
    private static final String DATA_SEPARATOR = ",";
    private static final String EMPTY_SCV_TABLE_CELL = "\"\"";

    @Override
    public List<FruitTransaction> parseTransactions(List<String> transactions) {
        return transactions.stream()
                .skip(TITLE_POSITION)
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLine(String line) {
        String[] data = line.split(DATA_SEPARATOR);
        operationCellIsNotEmpty(data[OPERATION_POSITION]);
        fruitCellIsNotEmpty(data[FRUIT_POSITION]);
        quantityIsValidInteger(data[QUANTITY_POSITION]);
        return new FruitTransaction(
                FruitTransaction.Operation.getByCharacter(data[OPERATION_POSITION]),
                data[FRUIT_POSITION],
                Integer.parseInt(data[QUANTITY_POSITION]));
    }

    private void operationCellIsNotEmpty(String operationCell) {
        if (operationCell.equals(EMPTY_SCV_TABLE_CELL)) {
            throw new RuntimeException("Operation can't be empty.");
        }
    }

    private void fruitCellIsNotEmpty(String fruitCell) {
        if (fruitCell.equals(EMPTY_SCV_TABLE_CELL)) {
            throw new RuntimeException("Fruit can't be empty.");
        }
    }

    private void quantityIsValidInteger(String quantityCell) {
        if (quantityCell.equals(EMPTY_SCV_TABLE_CELL)) {
            throw new RuntimeException("Quantity can't be empty.");
        }
        try {
            int quantity = Integer.parseInt(quantityCell);
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity can't be <= 0. Actual quantity: " + quantityCell);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid quantity: " + quantityCell + e);
        }
    }
}
