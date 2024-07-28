package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputList) {
        if (inputList == null) {
            throw new RuntimeException("Input list is null");
        }
        inputList.remove(0);
        return inputList.stream()
                 .map(s -> s.split(SPLITTER))
                 .map(s -> new FruitTransaction(FruitTransaction.Operation.getFromCode(
                                                                 s[OPERATION_INDEX]),
                                                                 s[FRUIT_INDEX],
                                                Integer.parseInt(s[QUANTITY_INDEX])))
                 .toList();
    }
}
