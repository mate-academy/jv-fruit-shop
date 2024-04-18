package core.basesyntax.dao;

import core.basesyntax.FruitTransaction;
import java.util.List;

public class ConverterDataToObjImpl {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_SEQUENCE = 0;
    private static final int FRUIT_NAME_SEQUENCE = 1;
    private static final int FRUIT_QUANTITY_SEQUENCE = 2;

    public List<FruitTransaction> convertAll(List<String> listOfStrings) {
        List<FruitTransaction> list = listOfStrings.stream()
                .map(line -> line.split(SEPARATOR))
                .map(fruitTransaction -> new FruitTransaction(fruitTransaction[OPERATION_SEQUENCE],
                        fruitTransaction[FRUIT_NAME_SEQUENCE],
                        Integer.parseInt(fruitTransaction[FRUIT_QUANTITY_SEQUENCE])))
                .toList();
        return list;
    }
}
