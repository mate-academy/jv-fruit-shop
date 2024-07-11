package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int SIZE_OF_TRANSACTION_STRING = 3;

    @Override
    public List<FruitTransaction> convertToTransactions(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();
        inputReport.stream()
                .filter(s -> !s.startsWith("type"))
                .map(this::parseToFruitTransaction)
                .forEach(transactions::add);
        return transactions;
    }

    private FruitTransaction parseToFruitTransaction(String inputReportString) {
        String[] inputToArray = inputReportString.split(",");
        FruitTransaction fruitTransaction = null;
        if (isValidData(inputToArray)) {
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .fromCode(inputToArray[OPERATION_TYPE_INDEX]);
            String fruitName = inputToArray[FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(inputToArray[QUANTITY_INDEX]);
            fruitTransaction = FruitTransaction.transactionOf(operation, fruitName, quantity);
        }
        return fruitTransaction;
    }

    private boolean isValidData(String[] inputToArray) {
        if (inputToArray.length != SIZE_OF_TRANSACTION_STRING) {
            throw new RuntimeException("Length for parsed string must be three, actual length "
                    + inputToArray.length);
        }
        try {
            Integer.parseInt(inputToArray[QUANTITY_INDEX]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid format of quantity"
                    + inputToArray[QUANTITY_INDEX]);
        }
        return true;
    }
}
