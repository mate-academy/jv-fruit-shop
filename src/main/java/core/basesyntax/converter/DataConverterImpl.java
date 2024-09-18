package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int HEADER_LINE_INDEX = 0;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = HEADER_LINE_INDEX + 1; i < data.size(); i++) {
            String[] parts = data.get(i).split(",");

            if (parts.length >= 3) {
                try {
                    FruitTransaction.Operation operation =
                            FruitTransaction.Operation.fromCode(parts[0].trim());
                    String fruit = parts[1].trim();
                    int quantity = Integer.parseInt(parts[2].trim());

                    transactions.add(new FruitTransaction(operation, fruit, quantity));
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Invalid number format in line " + (i + 1)
                            + ": " + parts[2], e);
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("Invalid operation code in line " + (i + 1)
                            + ": " + parts[0], e);
                }
            } else {
                System.err.println("Invalid data format at line " + (i + 1));
            }
        }
        return transactions;
    }
}
    /*@Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < data.size(); i++) {
            String[] parts = data.get(i).split(",");
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.fromCode(parts[0].trim());
            String fruit = parts[1].trim();
            int quantity = Integer.parseInt(parts[2].trim());

            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }*/

