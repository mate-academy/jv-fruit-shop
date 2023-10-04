package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParsingService;
import java.util.List;
import java.util.stream.Collectors;

public class ParcingCsvServiceImpl implements ParsingService {
    private static final String SEPERATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int INDEX_SKIPPED_LINE = 1;

    @Override
    public List<FruitTransaction> parsingDataFromListOfStrings(List<String> list) {
        return list.stream().skip(INDEX_SKIPPED_LINE)
                .map(transaction -> transaction.split(SEPERATOR))
                .map(transaction -> new FruitTransaction(transaction[FRUIT_INDEX],
                        parseOperationFromInput(transaction[OPERATION_INDEX]),
                        Integer.parseInt(transaction[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation parseOperationFromInput(String input) {
        for (FruitTransaction.Operation operationValue : FruitTransaction.Operation.values()) {
            if (input.equals(operationValue.getCode())) {
                return operationValue;
            }
        }
        throw new RuntimeException("Input for operation was incorrect " + input);
    }
}
