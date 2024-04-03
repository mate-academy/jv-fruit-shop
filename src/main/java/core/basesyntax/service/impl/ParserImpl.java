package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";
    private static final int FIELDS_COUNT = 3;

    @Override
    public List<FruitTransaction> parseAll(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : lines) {
            try {
                String[] transaction = line.split(SEPARATOR);
                if (transaction.length > FIELDS_COUNT) {
                    throw new RuntimeException("Invalid type of transaction" + transaction);
                }
                transactions.add(new FruitTransaction(
                        Operation.getOperationFromCode(transaction[OPERATION_INDEX]),
                        transaction[FRUIT_INDEX],
                        Integer.parseInt(transaction[QUANTITY_INDEX])));
            } catch (RuntimeException e) {
                throw new RuntimeException("Fail on parsing", e);
            }
        }
        return transactions;
    }
}
