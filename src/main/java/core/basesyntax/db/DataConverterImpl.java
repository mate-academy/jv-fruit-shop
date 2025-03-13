package core.basesyntax.db;

import core.basesyntax.service.FruitTransaction;
import java.util.Arrays;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> fruitTransaction(List<String> reader) {

        return reader.stream()
                .map(s -> s.split(","))
                .filter(s -> s[0].length() == 1)
                .map(s -> new FruitTransaction(
                        Arrays.stream(FruitTransaction.Operation.values())
                                .filter(op -> op.getCode().equals(s[0]))
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException(
                                        "Invalid operation code: " + s[0])),
                        s[1],
                        Integer.parseInt(s[2])
                ))
                .toList();
    }
}
