package service;

import java.util.ArrayList;
import java.util.List;
import model.FruitDataDto;

public class DataParserImpl implements DataParser {

    public static final String COMMA = ",";
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    public static final int DATA_INDEX = 1;

    @Override
    public List<FruitDataDto> parseData(List<String> data) {
        List<String> dataWithoutTitle = data.subList(DATA_INDEX, data.size());
        List<FruitDataDto> parsedData = new ArrayList<>();
        DataValidator dataValidator = new DataValidatorImpl();
        for (String record: dataWithoutTitle) {
            dataValidator.validateRecord(record);
            String[] splitData = record.split(COMMA);
            parsedData.add(new FruitDataDto(splitData[OPERATION_INDEX],
                    splitData[FRUIT_INDEX],
                    Integer.parseInt(splitData[QUANTITY_INDEX])));
        }
        return parsedData;
    }
}
