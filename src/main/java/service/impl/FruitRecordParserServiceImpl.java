package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitRecordDto;
import service.FruitRecordParserService;
import service.validator.DataValidator;

public class FruitRecordParserServiceImpl implements FruitRecordParserService {
    public static final String COMMA = ",";

    @Override
    public List<FruitRecordDto> getRecord(List<String> stringsFromFile) {
        List<FruitRecordDto> outputList = new ArrayList<>();
        for (String string : stringsFromFile) {
            if (!new DataValidator().test(string)) {
                continue;
            }
            String[] stringElements = string.split(COMMA);
            outputList.add(new FruitRecordDto(stringElements[0],
                    stringElements[1],
                    Integer.parseInt(stringElements[2])));
        }
        return outputList;
    }
}
