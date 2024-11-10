package core.basesyntax.service.impl;

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
    private static final String INPUT_POTENTIAL_FIRST_ROW = "type,fruit,quantity";
    private static final int START_ROW_INDEX = 0;

    @Override
    public List<FruitTransaction> convertStringsDataToFruitTransactions(
            List<String> stringsData) {
        List<FruitTransaction> list = new ArrayList<>();
        int index = START_ROW_INDEX;
        if (stringsData.get(index).equals(INPUT_POTENTIAL_FIRST_ROW)) {
            index++;
        }
        for (; index < stringsData.size(); index++) {
            String row = stringsData.get(index).trim();
            String[] arr = row.split(DATA_SPLITTER);
            if (arr.length != EXPECTED_ARRAY_LENGTH) {
                throw new RuntimeException("Invalid input");
            }
            FruitTransaction fruitTransaction = new FruitTransaction(
                    Operation.getByCode(arr[OPERATION_INDEX]),
                    arr[FRUIT_INDEX],
                    Integer.parseInt(arr[QUANTITY_INDEX])
            );
            list.add(fruitTransaction);
        }
        return list;
    }
}
