package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class FruitStorage {
    public static final Map<String, Integer> fruitTransactionStorage = new HashMap<>();

    public static int getQuantity(String fruit) {
        return fruitTransactionStorage.entrySet().stream()
                .filter(k -> k.getKey().equals(fruit))
                .flatMapToInt(v ->
                        IntStream.of(v.getValue()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can not find quantity of fruit :"
                        + fruit
                        + " in database"));

    }
}
