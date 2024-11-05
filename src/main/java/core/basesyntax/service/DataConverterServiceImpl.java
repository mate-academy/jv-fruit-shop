package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterServiceImpl implements DataConverterService {
    private static final String COMMA_SEPARATOR = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int VALID_ARRAY_LENGTH = 3;

    @Override
    public List<FruitTransaction> convert(List<String> data) {
        return data.stream()
                .filter(FruitTransaction.Operation::startsWithOperation)
                .map(this::convertToFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction convertToFruitTransaction(String data) {
        String[] dataSplit = splitIfValid(data);
        FruitTransaction.Operation operation
                = FruitTransaction.Operation.convertToOperation(dataSplit[OPERATION_TYPE_INDEX]);
        String fruit = dataSplit[FRUIT_INDEX];
        int quantity = Integer.parseInt(dataSplit[QUANTITY_INDEX]);
        return new FruitTransaction(operation, fruit, quantity);
    }

    private String[] splitIfValid(String data) {
        String[] dataSplit = data.split(COMMA_SEPARATOR);
        if (dataSplit.length != VALID_ARRAY_LENGTH) {
            throw new InvalidArraySplitLength("Data split length is not 3, but: "
                    + dataSplit.length);
        }
        try {
            Integer.parseInt(dataSplit[QUANTITY_INDEX]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Expected a numeric value, but got: "
                    + dataSplit[QUANTITY_INDEX]);
        }
        return dataSplit;
    }
}
