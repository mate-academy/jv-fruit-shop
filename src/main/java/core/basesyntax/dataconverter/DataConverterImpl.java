package core.basesyntax.dataconverter;

import core.basesyntax.fruittransaction.FruitTransaction;
import core.basesyntax.fruittransaction.Operation;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertFromStrings(List<String> data) {
        return data.stream().skip(1).map(this::convert).collect(Collectors.toList());
    }

    private FruitTransaction convert(String s) {
        String[] details = s.split(",");

        Operation operation = Arrays.stream(Operation.values())
                .filter(v -> Objects.equals(v.getCode(), details[0]))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        String fruitName = details[1];
        int quantity = Integer.parseInt(details[2]);

        if (quantity < 0) {
            throw new IllegalArgumentException("Operation value can't be less than 0");
        }

        return new FruitTransaction(operation, fruitName, quantity);
    }
}
