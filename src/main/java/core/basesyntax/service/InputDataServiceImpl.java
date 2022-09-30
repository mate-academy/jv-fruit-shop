package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.Operation;
import java.util.List;
import java.util.stream.Collectors;

public class InputDataServiceImpl implements InputDataService {
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int FRUIT_QUANTITY_POSITION = 2;

    @Override
    public List<FruitTransaction> stringToFruitTransactionConverter(List<String> inputText) {
        return inputText.stream()
                .map(this::getFromString)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromString(String line) {
        String[] fields = line.split(",");
        Operation operation = Operation.getEnumByTitle(fields[OPERATION_POSITION]);
        String fruitName = fields[FRUIT_POSITION];
        int quantity = Integer.parseInt(fields[FRUIT_QUANTITY_POSITION]);
        return new FruitTransaction(operation, fruitName, quantity);
    }
}
