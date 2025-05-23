package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> rawData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        final int[] lineCount = {0};
        rawData.stream()
                .filter(line -> line != null && !line.trim().isEmpty())
                .skip(1)
                .map(line -> line.split(SEPARATOR))
                .forEach(parts -> {
                    fruitTransactions
                            .add(new FruitTransaction(FruitTransaction.Operation.fromCode(parts[0]),
                                    parts[1],
                                    Integer.parseInt(parts[2])));
                });
        return fruitTransactions;
    }
}
