package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.FruitRecordDtoParser;
import java.util.List;
import java.util.stream.Collectors;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final long TITLE_LINE = 1;
    private static final String DATA_SEPARATOR = ",";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        return lines.stream()
                .skip(TITLE_LINE)
                .map(this::parseFruitRecord)
                .collect(Collectors.toList());
    }

    private FruitRecordDto parseFruitRecord(String activity) {
        String[] splitActivity = activity.split(DATA_SEPARATOR);
        if (splitActivity.length != 3) {
            throw new IllegalArgumentException("Wrong amount of input parameters "
                    + "required 3 but provided -  " + splitActivity.length);
        }
        FruitRecordDto.Type type;
        try {
            type = FruitRecordDto.Type.valueOf(splitActivity[TYPE_INDEX]);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Illegal type argument passed in file", ex);
        }
        long amount = Integer.parseInt(splitActivity[AMOUNT_INDEX]);
        if (amount < 0) {
            throw new IllegalArgumentException("Balance can't be less then zero");
        }
        return new FruitRecordDto(type, splitActivity[FRUIT_INDEX], amount);
    }
}
