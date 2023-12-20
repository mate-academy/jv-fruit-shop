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
                .map(this::getFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFruitTransaction(String fruitRow) {
        String[] splittedRow = fruitRow.split(",");
        String operationCode = splittedRow[OPERATION_INDEX];
        FruitTransaction.Operation operation = FruitTransaction.Operation.getByCode(operationCode);
        String fruitName = splittedRow[FRUIT_NAME_INDEX];
        int fruitQuantity = Integer.parseInt(splittedRow[FRUIT_QUANTITY_INDEX].trim());
        validateFruitQuantity(fruitQuantity);
        return new FruitTransaction(operation, fruitName, fruitQuantity);
    }

    private void validateFruitQuantity(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Wrong quantity input");
        }
    }
}
