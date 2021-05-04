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
    private static final int OPERATION_TYPE_ELEMENT = 0;
    private static final int FRUIT_NAME_ELEMENT = 1;
    private static final int FRUIT_COUNT_ELEMENT = 2;

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        ValidationData validationData = new ValidationDataImpl();
        List<FruitRecordDto> fruitRecordDtos = new ArrayList<>(lines.size());
        for (String line:lines) {
            if (line.equals(COLUMN_NAMES)) {
                continue;
            }
            String[] lineSplit = line.split(",");
            if (validationData.validationData(lineSplit[OPERATION_TYPE_ELEMENT],lineSplit[FRUIT_NAME_ELEMENT],
                    lineSplit[FRUIT_COUNT_ELEMENT])) {
                FruitRecordDto dto = new FruitRecordDto(OperationType
                        .valueOf(lineSplit[OPERATION_TYPE_ELEMENT].trim()), lineSplit[FRUIT_NAME_ELEMENT],
                        Integer.parseInt(lineSplit[FRUIT_COUNT_ELEMENT]));
                fruitRecordDtos.add(dto);
            }
        }
        return fruitRecordDtos;
    }
}
