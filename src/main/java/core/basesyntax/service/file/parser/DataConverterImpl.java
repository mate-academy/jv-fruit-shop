package core.basesyntax.service.file.parser;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int LENGTH_OF_PART = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        if (inputReport == null) {
            throw new RuntimeException("Input report for processing was null." + inputReport);
        }

        return inputReport.stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    if (parts.length != LENGTH_OF_PART) {
                        throw new IllegalArgumentException(
                                "Invalid line size. Expected 3 values, but got "
                                        + parts.length + " : " + line
                        );
                    }
                    return parts;
                })
                .map(parts -> new FruitTransaction(
                        FruitTransaction.Operation.getEnumFromCode(parts[OPERATION_INDEX]),
                        new Fruit(parts[FRUIT_INDEX]),
                        Integer.parseInt(parts[AMOUNT_INDEX])
                ))
                .collect(Collectors.toList());
    }
}
