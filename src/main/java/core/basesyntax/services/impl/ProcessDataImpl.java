package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.ProcessData;
import java.util.List;
import java.util.stream.Stream;

public class ProcessDataImpl implements ProcessData {
    private static final String COMMA = ",";
    private static final int HEAD_INFO_INDEX = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public List<FruitTransaction> process(String inputData) {
        String[] records = inputData.split(LINE_SEPARATOR);
        return Stream.of(records)
                .skip(HEAD_INFO_INDEX)
                .map(this::convertDataToTransaction)
                .toList();
    }

    private FruitTransaction.OperationType getOperation(String code) {
        return Stream.of(FruitTransaction.OperationType.values())
                .filter(o -> o.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No operation following code: " + code));
    }

    private FruitTransaction convertDataToTransaction(String inputDataLine) {
        String[] data = inputDataLine.split(COMMA);
        return new FruitTransaction(getOperation(data[OPERATION_INDEX].trim()),
                data[FRUIT_TYPE_INDEX].trim(), Integer.parseInt(data[INDEX_OF_AMOUNT].trim()));
    }
}
