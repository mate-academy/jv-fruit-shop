package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";

    private FruitTransaction makeFruitTransaction(String inputReport) {
        String[] split = inputReport.split(SEPARATOR);

        if (split.length != 3) {
            throw new IllegalArgumentException("invalid fruit transaction format");
        }

        return new FruitTransaction(FruitTransaction.Operation.valueOfCode(split[0]),
                split[1], Integer.parseInt(split[2]));
    }

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream().map(this::makeFruitTransaction).toList();
    }
}
