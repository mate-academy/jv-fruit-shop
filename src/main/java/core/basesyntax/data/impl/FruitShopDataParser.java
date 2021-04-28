package core.basesyntax.data.impl;

import core.basesyntax.data.DataParser;
import core.basesyntax.model.Fruit;
import core.basesyntax.dto.TransactionDto;
import java.util.ArrayList;
import java.util.List;

public class FruitShopDataParser implements DataParser {
    private static final String SPLIT_REGEX = ",";
    private static final int REQUIRED_LENGTH = 1;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    @Override
    public List<TransactionDto> convert(List<String> listWithRawData) {
        List<TransactionDto> dataTransferObjects = new ArrayList<>(listWithRawData.size());
        for (String line : listWithRawData) {
            String[] elements = line.trim().split(SPLIT_REGEX);
            if (elements[ZERO].length() == REQUIRED_LENGTH) {
                dataTransferObjects.add(new TransactionDto(elements[ZERO],
                        new Fruit(elements[ONE]), Integer.parseInt(elements[TWO])));
            }
        }
        return dataTransferObjects;
    }
}
