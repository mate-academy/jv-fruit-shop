package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int TRANSACTION_PARTS_LENGTH = 3;
    private static final int CODE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int HEADER_LINE_SKIP = 1;
    private static final String DELIMITER = ",";

    @Override
    public List<FruitTransaction> convertToTransactions(List<String> transactions) {
        if (transactions.isEmpty()) {
            return List.of();
        }

        return transactions.stream()
                .skip(HEADER_LINE_SKIP)
                .map(this::parse)
                .toList();
    }

    private FruitTransaction parse(String transaction) {
        String[] transactionParts = transaction.split(DELIMITER);

        if (transactionParts.length != TRANSACTION_PARTS_LENGTH) {
            throw new RuntimeException("Invalid input data");
        }

        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setFruitName(transactionParts[FRUIT_NAME_INDEX].trim());
        int quantity;

        try {
            quantity = Integer.parseInt(transactionParts[QUANTITY_INDEX].trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid number format", e);
        }

        if (quantity < 0) {
            throw new RuntimeException("Quantity must be greater than or equal to zero");
        }
        fruitTransaction.setQuantity(quantity);

        try {
            fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(
                    transactionParts[CODE_INDEX].trim()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Unknown code" + transactionParts[CODE_INDEX].trim(), e);
        }

        return fruitTransaction;
    }
}
