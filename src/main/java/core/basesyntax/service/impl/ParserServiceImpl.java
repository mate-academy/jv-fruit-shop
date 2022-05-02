package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public ParserServiceImpl() {
    }

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        lines.remove(0);
        return lines.stream()
                .map(this::createTransactionFromLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction createTransactionFromLine(String line) {
        String[] data = line.split(",");
        return new FruitTransaction(getOperationByValue(data[OPERATION_INDEX]),
                new Fruit(data[FRUIT_INDEX]), Integer.parseInt(data[QUANTITY_INDEX]));
    }

    private FruitTransaction.Operation getOperationByValue(String value) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(o -> o.getOperation().equals(value))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unsupported operation: " + value));
    }
}
