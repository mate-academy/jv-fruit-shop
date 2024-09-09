package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        return lines.stream()
                .map(this::convertToFruitTransaction)
                .toList();
    }

    private FruitTransaction convertToFruitTransaction(String line) {
        String[] fields = line.split(",");
        return new FruitTransaction(
                FruitTransaction.Operation.fromCode(fields[0]),
                fields[1],
                Integer.parseInt(fields[2])
        );
    }
}
