package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.operations.OperationType;
import core.basesyntax.validate.ValidationData;
import core.basesyntax.validate.impl.ValidationDataImpl;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final String SKIP = "type,fruit,quantity";
    private static final int ZERO_ELEMENT = 0;
    private static final int FIRST_ELEMENT = 1;
    private static final int SECOND_ELEMENT = 2;

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        ValidationData validationData = new ValidationDataImpl();
        List<FruitRecordDto> fruitRecordDtos = new ArrayList<>(lines.size());
        for (String line:lines) {
            if (line.equals(SKIP)) {
                continue;
            }
            String[] lineSplit = line.split(",");
            if (validationData.validationData(lineSplit[ZERO_ELEMENT],lineSplit[FIRST_ELEMENT],
                    lineSplit[SECOND_ELEMENT])) {
                FruitRecordDto dto = new FruitRecordDto(OperationType
                        .valueOf(lineSplit[ZERO_ELEMENT].trim()), lineSplit[FIRST_ELEMENT],
                        Integer.parseInt(lineSplit[SECOND_ELEMENT]));
                fruitRecordDtos.add(dto);
            }
        }
        return fruitRecordDtos;
    }
}
