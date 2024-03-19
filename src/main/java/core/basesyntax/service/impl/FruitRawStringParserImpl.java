package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.DataFileCorrupted;
import core.basesyntax.exception.NegativeBalanceException;
import core.basesyntax.service.interfaces.FruitRawStringParser;
import java.util.ArrayList;
import java.util.List;

public class FruitRawStringParserImpl implements FruitRawStringParser {
    private static final int OPERATION_NEXT_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FIRST_CVS_LINE = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    private FruitStringsCheckImpl checkFruitsInFile = new FruitStringsCheckImpl();

    @Override
    public List<FruitTransactionDto> parsedFruitData(List<String> rawStrings) {
        if (!checkFruitsInFile.checkFruitQuantity(rawStrings)){
                throw new DataFileCorrupted("Some data in file is missing");
        }
        var fruitDto = new ArrayList<FruitTransactionDto>(rawStrings.size() - FIRST_CVS_LINE);
        for (int i = FIRST_CVS_LINE; i < rawStrings.size(); i++) {
            String line = rawStrings.get(i);
            String[] columns = line.split(",");
            try {
                int fruitQuantity = Integer.parseInt(columns[FRUIT_QUANTITY_INDEX].trim());
                var dto = new FruitTransactionDto(columns[OPERATION_NEXT_INDEX].trim(),
                        columns[FRUIT_NAME_INDEX].trim(),
                        fruitQuantity);
                fruitDto.add(dto);
            } catch (IllegalArgumentException e) {
                throw new DataFileCorrupted("Please check the quantity of the fruit it should be number(integer)" + e.getMessage());
            }
        }
        return fruitDto;
    }
}
