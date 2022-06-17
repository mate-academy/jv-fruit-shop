package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.FruitRecordDtoParser;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final String COMMA_JOINER = ",";
    private static final int LENGTH_OF_THE_CORRECT_DATA = 3;
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        List<FruitRecordDto> recordDtos = new ArrayList<>(lines.size());
        for (String line : lines) {
            String[] splitLine = line.split(COMMA_JOINER);
            if (splitLine.length < LENGTH_OF_THE_CORRECT_DATA) {
                throw new RuntimeException("Line is not valid");
            }
            try {
                FruitRecordDto dto = new FruitRecordDto(splitLine[INDEX_OPERATION],
                        splitLine[INDEX_FRUIT],
                        Integer.parseInt(splitLine[INDEX_QUANTITY]));
                recordDtos.add(dto);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Not valid data, quantity must be numbers", e);
            }
        }
        return recordDtos;
    }
}
