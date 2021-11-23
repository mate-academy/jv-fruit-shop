package core.basesyntax.service.file.impl;

import core.basesyntax.model.CsvLineDto;
import core.basesyntax.service.file.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserCsv implements Parser<CsvLineDto> {
    private static final int ACTION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_NUMBER_INDEX = 2;

    @Override
    public List<CsvLineDto> parse(String[] dataFromFile) {
        List<CsvLineDto> resultData = new ArrayList<>();
        for (String s : dataFromFile) {
            String[] data = s.split(",");
            if (data.length != 3) {
                throw new RuntimeException("Line in file is invalid!");
            }
            String action = data[ACTION_INDEX];
            String fruitName = data[FRUIT_NAME_INDEX];
            String fruitNumber = data[FRUIT_NUMBER_INDEX];
            resultData.add(new CsvLineDto(action, fruitName, fruitNumber));
        }
        return resultData;
    }
}
