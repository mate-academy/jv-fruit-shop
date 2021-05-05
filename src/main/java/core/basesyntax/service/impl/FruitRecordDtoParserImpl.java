package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.FruitRecordDtoParser;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final String COMMA_JOINER = ",";
    private static final int LENGTH_OF_THE_CORRECT_DATA = 3;

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        List<FruitRecordDto> recordDtos = new ArrayList<>(lines.size());
        for (String line : lines) {
            String[] splitLine = line.split(COMMA_JOINER);
            if (splitLine.length < LENGTH_OF_THE_CORRECT_DATA) {
                throw new RuntimeException("Line is not valid");
            }
            if (splitLine[0].equals("r")
                    || splitLine[0].equals("s")
                    || splitLine[0].equals("p") || splitLine[0].equals("b")) {
                try {
                    FruitRecordDto dto = new FruitRecordDto(splitLine[0], splitLine[1],
                            Integer.parseInt(splitLine[2]));
                    recordDtos.add(dto);
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("Not valid data, quantity must be numbers", e);
                }
            } else {
                throw new RuntimeException("Operation is not valid");
            }
        }
        return recordDtos;
    }
}
