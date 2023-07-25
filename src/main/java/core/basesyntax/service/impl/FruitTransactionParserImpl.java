package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    List<FruitTransaction> transactions = new ArrayList<>();
    FruitTransaction fruitTransaction = new FruitTransaction();

    @Override
    public List<FruitTransaction> getFruitTransactionsList(List<String> dataAll) {
        for (int i = 0; i < dataAll.size(); i++) {
            String[] data = dataAll.get(i).split(SEPARATOR);
            try {
                if (data[OPERATION_INDEX].equals("type")) {
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException();
            }

            FruitTransaction.Operation operation = fruitTransaction.getOperation(data[OPERATION_INDEX].trim());
            String fruit = data[FRUIT_INDEX];
            try {
                int quantity = Integer.parseInt(data[QUANTITY_INDEX]);
                transactions.add(new FruitTransaction(operation, fruit, quantity));
            } catch (NumberFormatException ex) {
                System.err.println("Invalid format");
            }
        }
        return transactions;
    }
}