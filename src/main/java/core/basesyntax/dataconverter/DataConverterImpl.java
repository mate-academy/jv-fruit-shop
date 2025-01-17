package core.basesyntax.dataconverter;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA_DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int HEADER_ROW_INDEX = 1;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = HEADER_ROW_INDEX; i < inputReport.size(); i++) {
            String line = inputReport.get(i);
            String[] array = line.split(COMMA_DELIMITER);
            Operation operation = Operation.getOperation(array[OPERATION_INDEX]);
            String fruit = array[FRUIT_INDEX];
            int quantity = Integer.parseInt(array[QUANTITY_INDEX]);

            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
