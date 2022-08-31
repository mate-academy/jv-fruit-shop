package core.basesyntax.service.impl;

import core.basesyntax.service.ParsingService;
import java.util.ArrayList;
import java.util.List;

public class ParsingServiceImpl implements ParsingService {
    private static final String DELIMITER = ",";

    @Override
    public List<String[]> parseData(List<String> data) {
        List<String[]> parsedData = new ArrayList<>();
        for (String oneLine : data) {
            parsedData.add(oneLine.split(DELIMITER));
        }
        return parsedData;
    }
}
