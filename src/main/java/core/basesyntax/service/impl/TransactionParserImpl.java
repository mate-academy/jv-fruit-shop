package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final String COMMA = ",";
    private static final int NUMBER_OF_PARTS = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUITNAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> inputLines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < inputLines.size(); i++) {
            transactions.add(parseLine(inputLines.get(i)));
        }
        return transactions;
    }

    private FruitTransaction parseLine(String line) {
        String[] parts = line.split(COMMA);
        if (parts.length != NUMBER_OF_PARTS) {
            throw new IllegalArgumentException("Invalid line in input file.");
        }
        FruitTransaction.Operation operation =
                FruitTransaction.Operation.of(parts[OPERATION_INDEX]);
        FruitTransaction transaction = new FruitTransaction(operation,
                parts[FRUITNAME_INDEX], Integer.parseInt(parts[QUANTITY_INDEX]));
        return transaction;
    }
}
