package service.impl;

import interfaces.DataConverter;
import java.util.Arrays;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        if (data != null) {
            return data.stream()
                    .skip(1)
                    .filter(s -> !s.isEmpty())
                    .map(this::toTransaction)
                    .toList();
        } else {
            throw new IllegalArgumentException("List is null");
        }
    }

    private FruitTransaction toTransaction(String data) {
        String[] split = data.split(",");
        if (split.length != 3) {
            throw new IllegalArgumentException("Incorrect line: " + Arrays.toString(split));
        }
        FruitTransaction.Operation operation
                = FruitTransaction.Operation.fromCode(split[0]);
        String fruit
                = split[1];
        int quantity = Integer.parseInt(split[2]);
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative. Got: " + split[2]);
        }
        return new FruitTransaction(operation, fruit, quantity);
    }
}
