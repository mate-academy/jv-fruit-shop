package core.basesyntax.serviceparser;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length != 3 || "type".equals(parts[0])) {
                continue;
            }
            try {
                FruitTransaction.Operation operation =
                        FruitTransaction.Operation.valueOf(parts[0].toUpperCase());
                String fruit = parts[1];
                int quantity = Integer.parseInt(parts[2]);

                transactions.add(new FruitTransaction(operation, fruit, quantity));
            } catch (NumberFormatException e) {
                System.err.println("Invalid quantity format in line: " + line);
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid operation type in line: " + line);
            }
        }
        return transactions;
    }
}
