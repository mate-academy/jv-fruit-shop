package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserServiceImpl implements DataParserService {
    private static final String DELIMITER = ",";

    public List<FruitTransaction> parseData(List<String> list) {
        return list.stream()
                .skip(1)
                .map(s -> {
                    FruitTransaction newFruitTransaction = new FruitTransaction();
                    String[] data = s.split(DELIMITER);
                    FruitTransaction.Operation operation = Arrays
                            .stream(FruitTransaction.Operation.values())
                            .filter(value -> value.getCode()
                                    .equals(data[0].trim()))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("No such operation"));
                    newFruitTransaction.setOperation(operation);
                    newFruitTransaction.setFruit(data[1]);
                    newFruitTransaction.setQuantity(Integer.parseInt(data[2].trim()));
                    return newFruitTransaction;
                }).collect(Collectors.toList());
    }
}
