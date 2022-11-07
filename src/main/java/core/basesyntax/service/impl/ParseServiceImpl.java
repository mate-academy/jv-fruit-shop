package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    private static final int TYPE_OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(this::getFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFruitTransaction(String line) {
        String[] splitArray = line.trim().split(",");
        return new FruitTransaction((getOperation(splitArray[TYPE_OPERATION_INDEX])),
        new Fruit(splitArray[FRUIT_INDEX]),Integer.parseInt(splitArray[QUANTITY_INDEX]));
    }

    private FruitTransaction.Operation getOperation(String name) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getOperation().equals(name)) {
                return operation;
            }
        }
        throw new RuntimeException("No such element found");
    }
}
