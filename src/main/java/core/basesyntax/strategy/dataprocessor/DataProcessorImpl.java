package core.basesyntax.strategy.dataprocessor;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class DataProcessorImpl implements DataProcessor {
    private static final int REMOVE_NAMES_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransactions(String data) {
        List<String[]> parsedData = parseDataRowComma(data);
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String[] transactionData : parsedData) {
            Operation operation = Operation.fromCode(transactionData[OPERATION_INDEX]);
            String fruit = transactionData[FRUIT_INDEX];
            int quantity = Integer.parseInt(transactionData[QUANTITY_INDEX]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }

    private List<String[]> parseDataRowComma(String data) {
        String[] splitBySeparator = data.split("\n");
        List<String[]> listSeparatorComma = new ArrayList<>();
        for (String s : splitBySeparator) {
            listSeparatorComma.add(s.split(","));
        }
        listSeparatorComma.remove(REMOVE_NAMES_INDEX);
        return listSeparatorComma;
    }
}
