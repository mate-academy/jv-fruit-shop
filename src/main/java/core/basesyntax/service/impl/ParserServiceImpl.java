package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> fruits) {
        return fruits.stream()
                .skip(1)
                .map(fruit -> fruit.split(","))
                .map(splitted -> {
                    String fruitOpCode = splitted[OPERATION_INDEX];
                    FruitTransaction.Operation operation = FruitTransaction.Operation
                                    .getByCode(fruitOpCode);
                    String fruitName = splitted[FRUIT_NAME_INDEX];
                    int fruitQuantity = Integer.parseInt(splitted[FRUIT_QUANTITY_INDEX].trim());
                    if (fruitQuantity < 0) {
                        throw new RuntimeException("Wrong quantity input");
                    }
                    return new FruitTransaction(operation, fruitName, fruitQuantity);
                })
                .collect(Collectors.toList());
    }
}
