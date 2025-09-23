package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA = ",";
    private static final int TYPE_SERVICE = 0;
    private static final int FRUIT = 1;
    private static final int COUNT_OF_FRUIT = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> readFile) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String report : readFile) {
            String[] reportSplit = report.split(COMMA);
            if (reportSplit.length != 3) {
                throw new RuntimeException(
                        "Invalid array: expected 3 elements, but got " + reportSplit.length
                                + ". Array contents: " + Arrays.toString(reportSplit)
                );
            }
            String code = reportSplit[TYPE_SERVICE];
            String fruit = reportSplit[FRUIT];
            int quantity = Integer.parseInt(reportSplit[COUNT_OF_FRUIT]);
            FruitTransaction.Operation operationCode = FruitTransaction.Operation.getByCode(code);
            FruitTransaction fruitTransaction
                    = new FruitTransaction(operationCode, fruit, quantity);
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
