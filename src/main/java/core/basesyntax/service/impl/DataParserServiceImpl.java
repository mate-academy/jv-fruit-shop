package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserServiceImpl implements DataParserService {
    private static final String DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public List<FruitTransaction> parseData(List<String> list) {
        return list.stream()
                .skip(1)
                .map(s -> {
                    FruitTransaction newFruitTransaction = new FruitTransaction();
                    String[] data = s.split(DELIMITER);
                    FruitTransaction.Operation operation = Arrays
                            .stream(FruitTransaction.Operation.values())
                            .filter(value -> value.getCode()
                                    .equals(data[OPERATION_INDEX].trim()))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("No such operation"));
                    newFruitTransaction.setOperation(operation);
                    newFruitTransaction.setFruit(data[FRUIT_INDEX]);
                    newFruitTransaction.setQuantity(Integer.parseInt(data[QUANTITY_INDEX].trim()));
                    return newFruitTransaction;
                }).collect(Collectors.toList());
    }
}
