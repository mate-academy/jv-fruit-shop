package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionConvertor {
    private static final int TYPE_INDEX = 0;
    private static final int ONE = 1;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static String SEPARATOR = ",";

    public List<FruitTransaction> convertToTransactionsList(List<String> lines) {
        List<String[]> splitLines = convertToSplitLines(lines);
        return splitLines.stream()
                .map(line -> new FruitTransaction(FruitTransaction.Operation
                        .getOperation(line[TYPE_INDEX]),
                        line[FRUIT_INDEX],
                        Integer.parseInt(line[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }

    private static List<String[]> convertToSplitLines(List<String> lines) {
        return lines.stream()
                .skip(ONE)
                .map(line -> line.split(SEPARATOR)).toList();
    }
}
