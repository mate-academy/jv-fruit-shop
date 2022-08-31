package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.ParseTransaction;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ParseTransactionImpl implements ParseTransaction {
    private static final int INDEX_CHAR_ACTIVITY = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_COUNT = 2;
    private static final String CSV_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> processing(List<String> list) {
        return list.stream()
                .map(this::parseFruitTransaction)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseFruitTransaction(String string) {
        String[] array = string.split(CSV_SEPARATOR);
        Fruit fruit = new Fruit(array[INDEX_FRUIT]);
        TypeActivity typeActivity = parseTypeActivity(array[INDEX_CHAR_ACTIVITY]);
        return typeActivity == null ? null : new FruitTransaction(
                    typeActivity,
                    fruit,
                    Integer.parseInt(array[INDEX_COUNT])
                );
    }

    private TypeActivity parseTypeActivity(String value) {
        return Arrays.stream(TypeActivity.values())
                .filter(o -> o.getLabel().equals(value))
                .findFirst()
                .orElse(null);
    }
}
