package core.basesyntax.dataconverter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final int operationIndex = 0;
    private static final int fruitIndex = 1;
    private static final int amountIndex = 2;

    @Override
    public List<FruitTransaction> convert(List<String> csvLines) {
        return csvLines.stream()
                .skip(1)
                .map(l -> l.split(","))
                .map(arr -> new FruitTransaction(convertToOperation(arr[operationIndex]),
                        arr[fruitIndex], Integer.parseInt(arr[amountIndex])))
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation convertToOperation(String mark) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getMarkInFile().equals(mark)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Unknown Operation");
    }
}
