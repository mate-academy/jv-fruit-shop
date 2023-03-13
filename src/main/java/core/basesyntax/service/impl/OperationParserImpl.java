package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OperationParserImpl implements OperationParser {
    private static final int HEADER = 0;
    private static final String SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parseOperation(List<String> data) {
        if (isHeader(data)) {
            data.remove(HEADER);
        }
        return data.stream()
                .map(i -> i.split(SPLITTER))
                .map(i -> new FruitTransaction(getTransaction(i[OPERATION_INDEX]),
                        i[FRUIT_INDEX], Integer.parseInt(i[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getTransaction(String code) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(t -> t.getCode().equals(code))
                .findFirst().get();
    }

    private boolean isHeader(List<String> data) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .anyMatch(i -> !data.get(HEADER)
                        .split(SPLITTER)[OPERATION_INDEX]
                        .contains(i.getCode()));
    }
}
