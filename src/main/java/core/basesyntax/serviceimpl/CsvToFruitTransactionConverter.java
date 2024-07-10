package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class CsvToFruitTransactionConverter implements DataConverter<List<String>,
        List<FruitTransaction>> {
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    return new FruitTransaction(
                            FruitTransaction.Operation.fromCode(parts[TYPE]),
                            parts[FRUIT],
                            Integer.parseInt(parts[QUANTITY])
                    );
                })
                .collect(Collectors.toList());
    }
}
