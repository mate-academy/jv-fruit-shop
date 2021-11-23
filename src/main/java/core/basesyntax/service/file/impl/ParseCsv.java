package core.basesyntax.service.file.impl;

import core.basesyntax.model.ParsedLineFromFileCsv;
import core.basesyntax.service.file.Parse;
import java.util.LinkedList;
import java.util.List;

public class ParseCsv implements Parse<ParsedLineFromFileCsv> {
    private static final int ACTION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_NUMBER_INDEX = 2;

    @Override
    public List<ParsedLineFromFileCsv> parseDataFromFile(String[] dataFromFile) {
        List<ParsedLineFromFileCsv> resultData = new LinkedList<>();
        for (int i = 0; i < dataFromFile.length; i++) {
            String[] data = dataFromFile[i].split(",");
            if (data.length != 3) {
                throw new RuntimeException("Line: " + (i + 2) + " is invalid!");
            }
            String action = data[ACTION_INDEX];
            String fruitName = data[FRUIT_NAME_INDEX];
            String fruitNumber = data[FRUIT_NUMBER_INDEX];
            resultData.add(new ParsedLineFromFileCsv(action, fruitName, fruitNumber));
        }
        return resultData;
    }
}
