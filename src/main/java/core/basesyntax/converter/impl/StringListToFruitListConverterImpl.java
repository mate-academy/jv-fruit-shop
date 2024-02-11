package core.basesyntax.converter.impl;

import core.basesyntax.converter.StringListToFruitListConverter;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringListToFruitListConverterImpl implements StringListToFruitListConverter {
    private static final String CSV_DELIMITER = ",";
    private static final int ACTIVITY_TYPE_POS = 0;
    private static final int FRUIT_NAME_POS = 1;
    private static final int QUANTITY_POS = 2;

    @Override
    public List<FruitTransaction> parseList(List<String> fruit) {
        fruit.remove(0);
        return fruit.stream()
            .map(s -> s.split(CSV_DELIMITER))
            .peek((array) -> {
                if (array.length != 3) {
                    throw new IllegalArgumentException("Some column in csv file is absent");
                }
                if (array[ACTIVITY_TYPE_POS].isEmpty()) {
                    throw new IllegalArgumentException("Activity field can't be empty");
                }
                if (array[FRUIT_NAME_POS].isEmpty()) {
                    throw new IllegalArgumentException("Fruit name field can't be empty");
                }
                if (array[QUANTITY_POS].isEmpty()) {
                    throw new IllegalArgumentException("Quantity field can't be empty");
                }
                if (Integer.parseInt(array[QUANTITY_POS]) < 0) {
                    throw new IllegalArgumentException("Quantity value can't be negative");
                }
            })
            .map(array -> new FruitTransaction(
                    Stream.of(FruitTransaction.Operation.values())
                            .filter(operation ->
                                    operation.getCode().equals(array[ACTIVITY_TYPE_POS]))
                            .findFirst().orElseThrow(() ->
                                    new NoSuchElementException("Wrong operation type")),
                    array[FRUIT_NAME_POS],
                    Integer.parseInt(array[QUANTITY_POS])))
            .collect(Collectors.toList());
    }
}
