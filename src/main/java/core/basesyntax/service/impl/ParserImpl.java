package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final String COMMA = ",";
    private static final int NUMBER_OF_PARTS = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUITNAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> inputLines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : inputLines) {
            String[] parts = line.split(COMMA);
            if (parts.length == NUMBER_OF_PARTS) {
                String operationCode = parts[OPERATION_INDEX];
                String fruit = parts[FRUITNAME_INDEX];
                int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
                FruitTransaction.Operation operation = FruitTransaction.Operation.of(operationCode);
                FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
                transactions.add(transaction);
            }
        }
        return transactions;
    }
}
