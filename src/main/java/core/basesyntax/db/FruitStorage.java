package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class FruitStorage {
    public static final Map<String, Integer> fruitTransactionStorage = new HashMap<>();

    public static int getQuantity(String fruit) {
        return fruitTransactionStorage.entrySet().stream()
                .filter(fruitKey -> fruitKey.getKey().equals(fruit))
                .flatMapToInt(quantity ->
                        IntStream.of(quantity.getValue()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can not find quantity of fruit :"
                        + fruit
                        + " in database"));
    }
}
