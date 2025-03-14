package core.basesyntax.db;

import core.basesyntax.service.FruitTransaction;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {

    private static final Set<String> ALLOWED_OPERATIONS = Arrays.stream(FruitTransaction.Operation.values())
            .map(FruitTransaction.Operation::getCode)
            .collect(Collectors.toSet());


    @Override
    public List<FruitTransaction> fruitTransaction(List<String> reader) {

        return reader.stream()
                .map(s -> s.split(","))
                .filter(s -> ALLOWED_OPERATIONS.contains(s[0]))
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
