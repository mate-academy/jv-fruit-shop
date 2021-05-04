package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitRecordDtoParser;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final String FIRST_LINE_FROM_DATA = "type,fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        lines.remove(FIRST_LINE_FROM_DATA);
        if (lines.isEmpty()) {
            throw new RuntimeException("No data in the lines");
        }
        List<FruitRecordDto> recordDtos = new ArrayList<>(lines.size());
        for (String line : lines) {
            String[] splitData = line.split(SEPARATOR);
            recordDtos.add(
                    new FruitRecordDto(Operation.getOperationFromString(splitData[OPERATION]),
                            splitData[FRUIT_TYPE], Integer.parseInt(splitData[QUANTITY])));
        }
        return recordDtos;
    }
}
