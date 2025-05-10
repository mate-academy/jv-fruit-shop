package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            try {
                String[] elements = line.split(",");
                if (elements.length != 3) {
                    throw new IllegalArgumentException("Invalid input format: " + line);
                }
                FruitTransaction.Operation operation =
                        FruitTransaction.Operation.fromCode(elements[0]);
                String fruit = elements[1];
                int quantity = Integer.parseInt(elements[2]);
                transactions.add(new FruitTransaction(operation, fruit, quantity));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        "Invalid quantity in line: " + line, e);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(
                        "Error processing line: " + line, e);
            }
        }
        return transactions;
    }
}
