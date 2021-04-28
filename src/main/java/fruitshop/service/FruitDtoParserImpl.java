package fruitshop.service;

import fruitshop.model.dto.FruitDto;
import fruitshop.service.operation.OperationType;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FruitDtoParserImpl implements FruitDtoParser {
    private static final String DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int COUNT_INDEX = 2;
    private static final String LINE_REGEX_PATTERN = "^(\\w),(\\w+),(-?\\d+)$";

    @Override
    public List<FruitDto> parse(List<String> fruitDataLines) {
        List<FruitDto> fruitDtoList = new ArrayList<>(fruitDataLines.size());
        for (String line : fruitDataLines) {
            if (Pattern.matches(LINE_REGEX_PATTERN, line)) {
                String[] fruitInfo = line.split(DELIMITER);
                FruitDto fruitDto = new FruitDto(getOperationType(fruitInfo[OPERATION_INDEX]),
                        fruitInfo[FRUIT_NAME_INDEX],
                        Integer.parseInt(fruitInfo[COUNT_INDEX]));
                fruitDtoList.add(fruitDto);
            }
        }
        return fruitDtoList;
    }

    private OperationType getOperationType(String shortCut) {
        for (OperationType type : OperationType.values()) {
            if (type.getShortCut().equals(shortCut)) {
                return type;
            }
        }
        throw new RuntimeException("Incorrect operation name \"" + shortCut + "\" is used");
    }
}
