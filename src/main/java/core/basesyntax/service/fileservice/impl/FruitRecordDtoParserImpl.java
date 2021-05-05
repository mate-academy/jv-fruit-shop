package core.basesyntax.service.fileservice.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.fileservice.FruitRecordDtoParser;
import core.basesyntax.service.impl.OperationType;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final String REPLACE_REGEX = "\\W";
    private static final String REPLACE_REGEX_AMOUNT = "[^0-9-]";
    private static final int ZERO_COLUMN_INDEX = 0;
    private static final int FIRST_COLUMN_INDEX = 1;
    private static final int SECOND_COLUMN_INDEX = 2;
    private static final String COLUMN_SEPARATOR = ",";
    private static final String EMPTY_STRING = "";

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        List<FruitRecordDto> listOfLines = new ArrayList<>(lines.size());
        for (int i = 0; i < lines.size(); i++) {
            String[] singleLineList = lines.get(i).split(COLUMN_SEPARATOR);
            String operationType =
                    singleLineList[ZERO_COLUMN_INDEX]
                            .replaceAll(REPLACE_REGEX, EMPTY_STRING);
            if (operationType.length() == 1) {
                FruitRecordDto fruitRecordDto =
                        new FruitRecordDto(OperationType.getOperationType(operationType),
                                singleLineList[FIRST_COLUMN_INDEX]
                                        .replaceAll(REPLACE_REGEX, EMPTY_STRING),
                                Integer.parseInt(singleLineList[SECOND_COLUMN_INDEX]
                                        .replaceAll(REPLACE_REGEX_AMOUNT, EMPTY_STRING)));
                listOfLines.add(fruitRecordDto);
            }
        }
        return listOfLines;
    }
}
