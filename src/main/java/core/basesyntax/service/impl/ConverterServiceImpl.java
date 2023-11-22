package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConverterService;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterServiceImpl implements ConverterService {
    private static final String DELIMITER = ",";
    private static final int ELEMENT_NUMBER_FOR_OPERATION = 0;
    private static final int ELEMENT_NUMBER_FOR_FRUIT_NAME = 1;
    private static final int ELEMENT_NUMBER_FOR_FRUIT_AMOUNT = 2;

    @Override
    public List<FruitTransaction> convertToFruitTransactions(List<String> data) {
        return data.stream()
                .map(string -> string.split(DELIMITER))
                .map(array -> new FruitTransaction(FruitTransaction.Operation.getOperationByCode(
                        array[ELEMENT_NUMBER_FOR_OPERATION]), array[ELEMENT_NUMBER_FOR_FRUIT_NAME],
                        Integer.parseInt(array[ELEMENT_NUMBER_FOR_FRUIT_AMOUNT])))
                .collect(Collectors.toList());
    }
}
