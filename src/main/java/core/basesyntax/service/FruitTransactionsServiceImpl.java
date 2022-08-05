package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FruitTransactionsServiceImpl implements FruitTransactionsService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int LINES_TO_SKIP = 1;

    @Override
    public List<FruitTransaction> getFruitTransactions(List<String> lines) {
        return lines.stream()
                .skip(LINES_TO_SKIP)
                .map(line ->
                        new FruitTransaction(getConstantOfOperation(line
                                .split(",")[OPERATION_INDEX]),
                        new Fruit(line.split(",")[FRUIT_INDEX]),
                        Integer.parseInt(line.split(",")[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getConstantOfOperation(String operation) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(constant -> Objects.equals(constant.getOperation(), operation))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("This operation doesn't exist"));
    }
}
