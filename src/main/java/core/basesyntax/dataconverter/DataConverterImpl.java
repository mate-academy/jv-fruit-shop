package core.basesyntax.dataconverter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convert(List<String> csvLines) {
        return csvLines.stream()
                .skip(1)
                .map(l -> l.split(SEPARATOR))
                .map(arr -> new FruitTransaction(FruitTransaction
                        .Operation.convertToOperation(arr[OPERATION_INDEX]),
                        arr[FRUIT_INDEX], Integer.parseInt(arr[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }
}
