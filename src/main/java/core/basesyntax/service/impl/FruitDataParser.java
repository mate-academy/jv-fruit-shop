package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.DataParser;
import java.util.ArrayList;
import java.util.List;

public class FruitDataParser implements DataParser<FruitTransactionDto> {
    private static final String DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int DATA_WITHOUT_HEADER_INDEX = 1;

    @Override
    public List<FruitTransactionDto> parse(List<String> rawData) {
        List<FruitTransactionDto> fruitsList = new ArrayList<>(rawData.size());
        for (int i = DATA_WITHOUT_HEADER_INDEX; i < rawData.size(); i++) {
            String line = rawData.get(i);
            String[] strings = line.split(DELIMITER);
            FruitTransactionDto dto =
                    new FruitTransactionDto(strings[OPERATION_INDEX],
                            strings[FRUIT_INDEX],
                            Integer.parseInt(strings[QUANTITY_INDEX]));
            fruitsList.add(dto);
        }
        return fruitsList;
    }
}
