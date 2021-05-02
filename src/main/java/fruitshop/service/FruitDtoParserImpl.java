package fruitshop.service;

import fruitshop.exception.IncorrectOperationException;
import fruitshop.model.dto.FruitOperationDto;
import fruitshop.service.shopoperation.OperationType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FruitDtoParserImpl implements FruitDtoParser {
    private static final String DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int COUNT_INDEX = 2;
    private static final int COLUMN_NAMES_LINE_NUMBER = 0;
    private static final String LINE_REGEX_PATTERN = "^(\\w),(\\w+),(-?\\d*\\.?\\d*)$";

    @Override
    public List<FruitOperationDto> parse(List<String> fruitDataLines) {
        fruitDataLines.remove(COLUMN_NAMES_LINE_NUMBER);
        List<FruitOperationDto> fruitOperationDtoList = new ArrayList<>(fruitDataLines.size());
        for (String line : fruitDataLines) {
            if (!(Pattern.matches(LINE_REGEX_PATTERN, line))) {
                throw new IncorrectOperationException("Incorrect record of operation: "
                        + line);
            }
            String[] fruitInfo = line.split(DELIMITER);
            FruitOperationDto fruitOperationDto = new FruitOperationDto(
                    getOperationType(fruitInfo[OPERATION_INDEX]),
                    fruitInfo[FRUIT_NAME_INDEX],
                    new BigDecimal(fruitInfo[COUNT_INDEX]));
            fruitOperationDtoList.add(fruitOperationDto);
        }
        return fruitOperationDtoList;
    }

    private OperationType getOperationType(String shortCut) {
        for (OperationType type : OperationType.values()) {
            if (type.getShortCut().equals(shortCut)) {
                return type;
            }
        }
        throw new IncorrectOperationException("Incorrect operation name \""
                + shortCut + "\" is used");
    }
}
