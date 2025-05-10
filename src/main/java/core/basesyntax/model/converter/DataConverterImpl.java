package core.basesyntax.model.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();

        inputReport.stream()
                .skip(1L)
                .map(line -> line.split(SEPARATOR))
                .filter(parts -> parts.length == 3)
                .map(parts -> {
                    try {
                        return new FruitTransaction(
                                FruitTransaction.Operation.fromCode(parts[0]),
                                parts[1],
                                Integer.parseInt(parts[2])
                        );
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Invalid data:"
                                + String.join(SEPARATOR, parts), e);
                    }
                })
                .forEach(transactions::add);

        return transactions;
    }
}
