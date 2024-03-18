package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.InputDataParser;
import java.util.List;

public class FileInputDataParser implements InputDataParser {
    private static final String REGEX_COMMA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    public static final int HEADERS_LINE_NUMBER = 1;

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        return data.stream()
                .skip(HEADERS_LINE_NUMBER)
                .map(line -> line.split(REGEX_COMMA_SEPARATOR))
                .map(splitLine -> new FruitTransaction(
                        FruitTransaction.Operation.getOperationByCode(splitLine[OPERATION_INDEX]),
                        splitLine[FRUIT_INDEX],
                        Integer.parseInt(splitLine[QUANTITY_INDEX])
                )).toList();
    }
}
