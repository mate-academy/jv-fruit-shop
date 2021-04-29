package core.basesyntax.data.impl;

import core.basesyntax.data.DataParser;
import core.basesyntax.dto.TransactionDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class FruitShopDataParser implements DataParser {
    private static final String SPLIT_REGEX = ",";
    private static final int REQUIRED_LENGTH = 1;
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int FRUIT_AMOUNT = 2;

    @Override
    public List<TransactionDto> convert(List<String> listWithRawData) {
        List<TransactionDto> dataTransferObjects = new ArrayList<>(listWithRawData.size());
        for (String line : listWithRawData) {
            String[] elements = line.trim().split(SPLIT_REGEX);
            if (elements[OPERATION_TYPE].length() == REQUIRED_LENGTH) {
                dataTransferObjects.add(new TransactionDto(Operation
                        .getEnum(elements[OPERATION_TYPE]),
                        new Fruit(elements[FRUIT_NAME]),
                        Integer.parseInt(elements[FRUIT_AMOUNT])));
            }
        }
        return dataTransferObjects;
    }
}
