package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitRecordDto;
import service.FruitRecordParserService;
import service.validator.DataValidator;

public class FruitRecordParserServiceImpl implements FruitRecordParserService {
    public static final String COMMA = ",";
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitRecordDto> getRecord(List<String> stringsFromFile) {
        List<FruitRecordDto> outputList = new ArrayList<>();
        for (String string : stringsFromFile) {
            if (!new DataValidator().test(string)) {
                continue;
            }
            String[] stringElements = string.split(COMMA);
            outputList.add(new FruitRecordDto(stringElements[OPERATION_INDEX],
                    stringElements[FRUIT_INDEX],
                    Integer.parseInt(stringElements[QUANTITY_INDEX])));
        }
        return outputList;
    }
}
