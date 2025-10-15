package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.Arrays;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> report) {
        return report.stream()
                .map(str -> {
                    List<String> data = Arrays.asList(str.split(COMMA_SEPARATOR));
                    FruitTransaction.Operation operation
                            = FruitTransaction.Operation.fromCode(data.get(0));
                    String fruit = data.get(1);
                    int quantity = Integer.parseInt(data.get(2));

                    return new FruitTransaction(operation, fruit, quantity);
                })
                .toList();
    }
}
