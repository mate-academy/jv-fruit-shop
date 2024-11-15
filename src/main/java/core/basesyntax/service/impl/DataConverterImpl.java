package core.basesyntax.service.impl;

import core.basesyntax.exception.InvalidInputException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String DATA_SPLITTER = ",";
    private static final Integer OPERATION_INDEX = 0;
    private static final Integer FRUIT_INDEX = 1;
    private static final Integer QUANTITY_INDEX = 2;
    private static final int EXPECTED_ARRAY_LENGTH = 3;

    @Override
    public List<FruitTransaction> convertToFruitTransactions(
            List<String> stringsData) {
        List<FruitTransaction> list = new ArrayList<>();
        for (int index = 1; index < stringsData.size(); index++) {
            String row = stringsData.get(index).trim();
            String[] arr = row.split(DATA_SPLITTER);
            checkInputData(arr);
            FruitTransaction fruitTransaction = new FruitTransaction(
                    Operation.getByCode(arr[OPERATION_INDEX]),
                    arr[FRUIT_INDEX],
                    Integer.parseInt(arr[QUANTITY_INDEX])
            );
            list.add(fruitTransaction);
        }
        return list;
    }

    private void checkInputData(String[] arr) {
        if (arr.length != EXPECTED_ARRAY_LENGTH) {
            throw new InvalidInputException("Invalid input");
        }
        if (Integer.parseInt(arr[QUANTITY_INDEX]) < 0) {
            throw new InvalidInputException("Quantity can't be less than 0");
        }
    }
}
