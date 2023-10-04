package core.basesyntax.service.implementation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConversionService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataConversionServiceImpl implements DataConversionService {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int HEADER_SIZE = 1;
    private static final String SEPARATOR = System.lineSeparator();

    @Override
    public List<FruitTransaction> convert(String rawData) {
        return Arrays.stream(rawData.split(SEPARATOR))
                .skip(HEADER_SIZE)
                .map(this::convertLineToTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction convertLineToTransaction(String line) {
        String[] dataUnits = line.split(COMMA);
        FruitTransaction fruitTransaction = new FruitTransaction();
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(dataUnits[OPERATION_INDEX])) {
                fruitTransaction.setOperation(operation);
            }
        }
        fruitTransaction.setFruit(dataUnits[PRODUCT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(dataUnits[AMOUNT_INDEX]));
        return fruitTransaction;
    }
}


