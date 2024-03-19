package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.interfaces.FruitRawStringParser;
import java.util.ArrayList;
import java.util.List;

public class FruitRawStringParserImpl implements FruitRawStringParser {
    private static final int OPERATION_NEXT_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FIRST_CVS_LINE = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    List<FruitTransactionDto> parsedFruitData (List<String> rawStrings) {
        var fruitToDB = new ArrayList<FruitTransactionDto>(rawStrings.size() - FIRST_CVS_LINE);
        for (int i = FIRST_CVS_LINE; i < rawStrings.size(); i++) {
            String line = rawStrings.get(i);
            String[] columns = line.split(",");
            var dto = new FruitTransactionDto(columns[OPERATION_NEXT_INDEX], columns[FRUIT_NAME_INDEX], Integer.parseInt(FRUIT_QUANTITY_INDEX));
            fruitToDB.add(dto);
        }
        return fruitToDB;
    }
}
