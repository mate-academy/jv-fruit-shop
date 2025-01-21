package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int HEADERS_POSITION = 0;
    private static final String SEPARATOR = ",";

    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        inputReport.remove(HEADERS_POSITION);
        return inputReport.stream()
                .map(e -> mapToTransaction(e.split(SEPARATOR)))
                .toList();
    }

    private FruitTransaction mapToTransaction(String[] splitedReport) {
        String code = splitedReport[OPERATION_INDEX];
        Operation operation = Operation.fromCode(code);
        return new FruitTransaction(operation, splitedReport[FRUIT_INDEX],
                Integer.parseInt(splitedReport[AMOUNT_INDEX]));
    }
}
