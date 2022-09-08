package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseFruits;
import java.util.List;
import java.util.stream.Collectors;

public class ParseFruitsImpl implements ParseFruits {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(this::transaction)
                .collect(Collectors.toList());
    }

    @Override
    public FruitTransaction transaction(String line) {
        String[] splitLine = line.split(",");
        FruitTransaction.Operation findOperation =
                FruitTransaction.getOperation(splitLine[OPERATION_INDEX]);
        return new FruitTransaction(findOperation, splitLine[FRUIT_INDEX],
                Integer.parseInt(splitLine[FRUIT_QUANTITY_INDEX]));
    }
}

