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
        for (int i = 1; i < inputReport.size(); i++) {
            transactions.add(parseToFruitTransaction(inputReport.get(i)));
        }
        return transactions;
    }

    private FruitTransaction parseToFruitTransaction(String inputReportString) {
        String[] inputToArray = inputReportString.split(",");
        if (inputToArray.length == SIZE_OF_TRANSACTION_STRING) {
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .fromCode(inputToArray[OPERATION_TYPE_INDEX]);
            String fruitName = inputToArray[FRUIT_NAME_INDEX];
            try {
                int quantity = Integer.parseInt(inputToArray[QUANTITY_INDEX]);
                return FruitTransaction.transactionOf(operation, fruitName, quantity);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid format of quantity"
                        + inputToArray[QUANTITY_INDEX]);
            }
        } else {
            throw new RuntimeException("Invalid length of result line -" + inputToArray.length
                    + ". Length should be 3");
        }
    }
}
