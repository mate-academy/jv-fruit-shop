package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_POSITION_AFTER_SPLIT = 0;
    private static final int FRUIT_NAME_POSITION_AFTER_SPLIT = 1;
    private static final int QUANTITY_POSITION_AFTER_SPLIT = 2;
    private static final int EXPECTED_LENGTH_AFTER_SPLIT = 3;
    private static final int EXPECTED_LENGTH_OF_TYPE = 1;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> lines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : lines) {
            String[] parsedLine = parseValue(line);
            FruitTransaction.Operation operation =
                    validOperationValue(parsedLine[OPERATION_POSITION_AFTER_SPLIT]);
            String fruitName = parsedLine[FRUIT_NAME_POSITION_AFTER_SPLIT];
            int quantity = Integer.parseInt(parsedLine[QUANTITY_POSITION_AFTER_SPLIT]);
            fruitTransactions.add(new FruitTransaction(operation, fruitName, quantity));
        }
        return fruitTransactions;
    }

    private String[] parseValue(String line) {
        String[] split = line.split(",");
        if (split.length != EXPECTED_LENGTH_AFTER_SPLIT) {
            throw new IllegalArgumentException("Invalid input data: expected format "
                    + "'<type>,<fruit_name>,<quantity>'");
        }
        return split;
    }

    private FruitTransaction.Operation validOperationValue(String line) {
        if (line.length() != EXPECTED_LENGTH_OF_TYPE) {
            throw new RuntimeException("Type should be only singe character: " + line);
        }
        return FruitTransaction.Operation.fromCode(line);
    }
}
