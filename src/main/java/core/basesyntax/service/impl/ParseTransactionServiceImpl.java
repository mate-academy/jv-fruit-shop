package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParseTransactionService;
import java.util.List;

public class ParseTransactionServiceImpl implements ParseTransactionService {
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_NAME_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private static final String CSV_STRING_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseTransactions(List<String> transactions) {
        return transactions.stream()
                .map(this::parseTransaction)
                .toList();
    }

    private FruitTransaction parseTransaction(String transactionLine) {
        String[] stringParts = transactionLine.split(CSV_STRING_SEPARATOR);

        String fruitName = stringParts[FRUIT_NAME_POSITION];
        Operation operation = Operation.getByAbbreviation(stringParts[OPERATION_POSITION]);

        quantityValidation(stringParts);
        int quantity = Integer.parseInt(stringParts[QUANTITY_POSITION]);

        return new FruitTransaction(fruitName, operation, quantity);
    }

    private void quantityValidation(String[] stringParts) {
        if (stringParts[QUANTITY_POSITION].matches("^[1-9]\\\\d*|0$")) {
            throw new RuntimeException(
                    "Valid range is positive numbers, but it's: "
                            + stringParts[QUANTITY_POSITION]
            );
        }
    }
}
