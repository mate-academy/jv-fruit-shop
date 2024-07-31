package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final byte OPERATION_POSITION = 0;
    private static final byte FRUIT_POSITION = 1;
    private static final byte QUANTITY_POSITION = 2;
    private static final String DELIMETER = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        removeSpaces(inputReport);
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < inputReport.size(); i++) {
            String[] parts = inputReport.get(i).split(DELIMETER);
            if (parts.length != 3) {
                continue;
            }
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .fromCode(parts[OPERATION_POSITION]);
            String fruit = parts[FRUIT_POSITION];
            int quantity = Integer.parseInt(parts[QUANTITY_POSITION]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }

    private static List<String> removeSpaces(List<String> inputReport) {
        inputReport.replaceAll(string -> string.replace(" ", ""));
        return inputReport;
    }
}
