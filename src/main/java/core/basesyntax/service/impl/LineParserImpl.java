package core.basesyntax.service.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.LineParser;
import java.util.ArrayList;
import java.util.List;

public class LineParserImpl implements LineParser {
    private static final int OPERATION_CODE_NUMBER = 0;
    private static final int FRUIT_NUMBER = 1;
    private static final int QUANTITY_NUMBER = 2;
    private static final int REQUIRED_STRING_LENGTH = 3;

    @Override
    public List<FruitTransaction> createListOfTransactions(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split("\\.");
            if (parts.length == REQUIRED_STRING_LENGTH) {
                String operationCode = parts[OPERATION_CODE_NUMBER].trim();
                String fruit = parts[FRUIT_NUMBER].trim();
                int quantity = Integer.parseInt(parts[QUANTITY_NUMBER].trim());
                FruitTransaction.Operation operation =
                        FruitTransaction.Operation.fromCode(operationCode);
                if (operation != null) {
                    transactions.add(new FruitTransaction(operation, fruit, quantity));
                }
            }
        }
        return transactions;
    }
}
