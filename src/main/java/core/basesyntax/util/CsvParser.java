package core.basesyntax.util;

import core.basesyntax.transactions.FruitsTransaction;
import core.basesyntax.transactions.FruitsTransaction.Operation;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public static List<FruitsTransaction> parseTransactions(List<String[]> lines) {
        List<FruitsTransaction> transactions = new ArrayList<>();
        for (String[] tokens : lines) {
            if (tokens.length >= 3) {
                try {
                    Operation operation = Operation.fromCode(tokens[OPERATION_INDEX].trim());
                    String fruit = tokens[FRUIT_INDEX].trim();
                    int quantity = Integer.parseInt(tokens[QUANTITY_INDEX].trim());
                    transactions.add(new FruitsTransaction(operation, fruit, quantity));
                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid data format - " + e.getMessage());
                }
            } else {
                System.err.println("Invalid line format");
            }
        }
        return transactions;
    }
}
