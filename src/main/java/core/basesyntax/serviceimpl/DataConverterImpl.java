package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter<List<String>, List<FruitTransaction>> {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    return new FruitTransaction(
                            FruitTransaction.Operation.fromCode(parts[0]),
                            parts[1],
                            Integer.parseInt(parts[2])
                    );
                })
                .collect(Collectors.toList());

    }
}
