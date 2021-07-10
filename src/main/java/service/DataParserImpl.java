package service;

import java.util.ArrayList;
import java.util.List;
import model.FruitDataDto;

public class DataParserImpl implements DataParser {
    private static final String CSV_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int DATA_INDEX = 1;
    private static final String WHITE_SPACE = " ";
    private static final int FIRST_LINE_INDEX = 0;
    private DataValidator dataValidator;

    public DataParserImpl(DataValidator dataValidator) {
        this.dataValidator = dataValidator;
    }

    @Override
    public List<FruitDataDto> parseData(List<String> data) {
        List<FruitDataDto> parsedData = new ArrayList<>();
        dataValidator.validateFirstLine(data.get(FIRST_LINE_INDEX).replaceAll(WHITE_SPACE, ""));
        List<String> dataWithoutTitle = data.subList(DATA_INDEX, data.size());
        for (String record: dataWithoutTitle) {
            String recordWithoutWhiteSpace = record.replaceAll(WHITE_SPACE, "");
            dataValidator.validateRecord(recordWithoutWhiteSpace);
            String[] splitData = recordWithoutWhiteSpace.split(CSV_SEPARATOR);
            parsedData.add(new FruitDataDto(splitData[OPERATION_INDEX],
                    splitData[FRUIT_INDEX],
                    Integer.parseInt(splitData[QUANTITY_INDEX])));
        }
        return parsedData;
    }
}
