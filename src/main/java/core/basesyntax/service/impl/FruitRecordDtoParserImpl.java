package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitRecordDtoParser;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final String LINE_SEPARATOR = ",";
    private static final String SKIPPING_START_LINE_VALUE = "type";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        List<FruitRecordDto> recordDtos = new ArrayList<>(lines.size());
        for (String line : lines) {
            String[] listLines = line.split(LINE_SEPARATOR);
            if (line.contains(SKIPPING_START_LINE_VALUE)) {
                continue;
            }
            if (listLines.length != 3) {
                throw new RuntimeException("File line must contains 3 values");
            }
            FruitRecordDto dto = new FruitRecordDto(listLines[OPERATION_INDEX],
                    listLines[FRUIT_INDEX],
                    Integer.parseInt(listLines[AMOUNT_INDEX]));
            recordDtos.add(dto);
        }
        return recordDtos;
    }
}
