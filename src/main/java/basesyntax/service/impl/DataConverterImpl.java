package basesyntax.service.impl;

import basesyntax.model.FruitTransaction;
import basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        return lines.stream()
                .map(line -> line.split(","))
                .map(parts -> new FruitTransaction(
                        FruitTransaction.Operation.fromCode(parts[0]),
                        parts[1],
                        Integer.parseInt(parts[2])
                ))
                .collect(Collectors.toList());
    }
}
