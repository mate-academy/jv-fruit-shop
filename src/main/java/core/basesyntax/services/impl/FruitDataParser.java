package core.basesyntax.services.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.services.DataParser;
import java.util.ArrayList;
import java.util.List;

public class FruitDataParser implements DataParser<FruitTransactionDto> {
    private static final int HEADER_NUMBER = 1;
    private static final int OPERATION_CODE = 0;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransactionDto> parse(List<String> rawData) {
        List<FruitTransactionDto> dtoList = new ArrayList<>(rawData.size() - HEADER_NUMBER);
        for (int i = HEADER_NUMBER; i < rawData.size(); i++) {
            String[] columns = rawData.get(i).trim().split(",");
            var dto = new FruitTransactionDto(columns[OPERATION_CODE], columns[HEADER_NUMBER],
                    Integer.parseInt(columns[QUANTITY]));
            dtoList.add(dto);
        }
        return dtoList;
    }
}
