package core.basesyntax.services.impl;

import core.basesyntax.dto.TransactionDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.services.DataParser;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {
    private static final String COMMA = ",";
    private static final int OPERATION_TYPE = 0;
    private static final int OPERATION_LENGTH = 1;
    private static final int FRUIT_NAME = 1;
    private static final int FRUIT_AMOUNT = 2;

    @Override
    public List<TransactionDto> parse(List<String> dataList) {
        List<TransactionDto> convertedData = new ArrayList<>(dataList.size());
        for (String line : dataList) {
            String[] separatedElements = line.trim().split(COMMA);
            if (separatedElements[OPERATION_TYPE].length() == OPERATION_LENGTH) {
                convertedData.add(new TransactionDto(Operation
                        .getOperation(separatedElements[OPERATION_TYPE]),
                        new Fruit(separatedElements[FRUIT_NAME]),
                        Integer.parseInt(separatedElements[FRUIT_AMOUNT])));
            }
        }
        return convertedData;
    }
}
