package service.impl;

import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.List;
import model.FruitRecordDto;
import service.FruitRecordParserService;
import service.validator.DataValidator;

public class FruitRecordParserServiceImpl implements FruitRecordParserService {
    public static final String COMMA = ",";
    public static final int PROBABLY_TITLE_INDEX = 0;
    public static final int VALID_STRING_INDEX = 1;
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitRecordDto> getRecord(List<String> stringsFromFile) {
        List<FruitRecordDto> outputList = new ArrayList<>();
        DataValidator dataValidator = new DataValidator();
        List<String> listToParse;
        if (dataValidator.test(stringsFromFile.get(PROBABLY_TITLE_INDEX))) {
            listToParse = stringsFromFile;
        } else {
            listToParse = stringsFromFile.subList(VALID_STRING_INDEX, stringsFromFile.size());
        }
        for (String string : listToParse) {
            if (!dataValidator.test(string)) {
                throw new InvalidInputException("Invalid line in input file: " + string);
            }
            String[] stringElements = string.split(COMMA);
            outputList.add(new FruitRecordDto(stringElements[OPERATION_INDEX],
                    stringElements[FRUIT_INDEX],
                    Integer.parseInt(stringElements[QUANTITY_INDEX])));
        }
        return outputList;
    }
}
