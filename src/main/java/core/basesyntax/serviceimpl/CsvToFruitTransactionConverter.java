package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class CsvToFruitTransactionConverter implements DataConverter<List<String>,
        List<FruitTransaction>> {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    return new FruitTransaction(
                            FruitTransaction.Operation.fromCode(parts[TYPE_INDEX]),
                            parts[FRUIT_INDEX],
                            Integer.parseInt(parts[QUANTITY_INDEX])
                    );
                })
                .collect(Collectors.toList());
    }
}
