package service;

import java.util.ArrayList;
import java.util.List;
import model.FruitDataDto;

public class DataParserImpl implements DataParser {
    @Override
    public List<FruitDataDto> parseData(List<String> data) {
        List<FruitDataDto> parsedData = new ArrayList<>();
        DataValidator dataValidator = new DataValidatorImpl();
        for (String record: data) {
            dataValidator.validateRecord(record);
            String[] splitData = record.split(",");
            parsedData.add(new FruitDataDto(splitData[0],
                    splitData[1],
                    Integer.parseInt(splitData[2])));
        }
        return parsedData;
    }
}
