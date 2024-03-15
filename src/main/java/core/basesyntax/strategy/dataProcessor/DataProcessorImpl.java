package core.basesyntax.strategy.dataProcessor;

import core.basesyntax.model.FruitTransaction;

import java.util.ArrayList;
import java.util.List;

public class DataProcessorImpl implements DataProcessor {
    private static final int REMOVE_NAMES_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransactions(String data) {
        List<String[]> dataToWork = convertData(data);
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String[] transactionData : dataToWork) {
            FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(transactionData[OPERATION_INDEX]);
            String fruit = transactionData[FRUIT_INDEX];
            int quantity = Integer.parseInt(transactionData[QUANTITY_INDEX]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }

    private List<String[]> convertData(String data) {
        String[] splitBySeparator = data.split("\n");
        List<String[]> convert = new ArrayList<>();
        for (String s : splitBySeparator) {
            convert.add(s.split(","));
        }
        convert.remove(REMOVE_NAMES_INDEX);
        return convert;
    }
}
