package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvDataParser extends DataParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        if (data == null) {
            throw new RuntimeException("Failed to parse data. The income data is null");
        }

        return data.stream()
                .skip(1)
                .map(row -> {
                    String[] values = getValues(row);

                    Operation operation = this.calculateOperation(values[OPERATION_INDEX].trim());

                    if (operation == null) {
                        throw new RuntimeException("Operation is invalid "
                                + row);
                    }

                    String fruitName = values[FRUIT_NAME_INDEX].trim();

                    if (fruitName.isEmpty()) {
                        throw new RuntimeException("Fruit name is missing"
                                + row);
                    }

                    int quantity = this.getQuantity(values[QUANTITY_INDEX]);

                    return new FruitTransaction(
                            operation,
                            fruitName,
                            quantity
                    );
                })
                .collect(Collectors.toList());
    }

    private String[] getValues(String data) {
        String[] values = data.split(",");

        if (values.length != 3) {
            throw new RuntimeException("Wrong input format"
                    + data);
        }

        return values;
    }

    private Operation calculateOperation(String operation) {
        return Arrays.stream(Operation.values())
                .filter(el -> el.getCode().equals(operation))
                .findFirst()
                .orElse(null);
    }

    private int getQuantity(String data) {
        String quantity = data.trim();

        if (quantity.isEmpty()) {
            throw new RuntimeException("Quantity is empty "
                    + quantity);
        }

        int quantityNumber;

        try {
            quantityNumber = Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Failed to parse a string into number "
                    + data, e);
        }

        if (quantityNumber < 0) {
            throw new RuntimeException("Invalid input quantity."
                    + " The number cannot have a negative value "
                    + quantityNumber);
        }

        return quantityNumber;
    }
}
