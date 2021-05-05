package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.operations.OperationType;
import core.basesyntax.validate.ValidationData;
import core.basesyntax.validate.impl.ValidationDataImpl;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final String COLUMN_NAMES = "type,fruit,quantity";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_COUNT_INDEX = 2;

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        ValidationData validationData = new ValidationDataImpl();
        List<FruitRecordDto> fruitRecordDtos = new ArrayList<>(lines.size());
        for (String line:lines) {
            if (line.equals(COLUMN_NAMES)) {
                continue;
            }
            String[] lineSplit = line.split(",");
            switch (lineSplit[OPERATION_TYPE_INDEX].trim()) {
                case "b":
                    lineSplit[OPERATION_TYPE_INDEX] = "BALANCE";
                    break;
                case "p":
                    lineSplit[OPERATION_TYPE_INDEX] = "PURCHASE";
                    break;
                case "s":
                    lineSplit[OPERATION_TYPE_INDEX] = "SUPPLY";
                    break;
                case "r":
                    lineSplit[OPERATION_TYPE_INDEX] = "RETURN";
                    break;
            }
            if (validationData.validationData(lineSplit[OPERATION_TYPE_INDEX],lineSplit[FRUIT_NAME_INDEX],
                    lineSplit[FRUIT_COUNT_INDEX])) {
                FruitRecordDto dto = new FruitRecordDto(OperationType
                        .valueOf(lineSplit[OPERATION_TYPE_INDEX]), lineSplit[FRUIT_NAME_INDEX],
                        Integer.parseInt(lineSplit[FRUIT_COUNT_INDEX]));
                fruitRecordDtos.add(dto);
            }
        }
        return fruitRecordDtos;
    }
}
