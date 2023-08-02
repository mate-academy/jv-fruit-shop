package core.basesyntax.services.impl;

import core.basesyntax.constvars.Constants;
import core.basesyntax.exception.ValidationDataException;
import core.basesyntax.services.ParseCsvService;
import java.util.ArrayList;
import java.util.List;

public class ParseCsvServiceImpl implements ParseCsvService {
    @Override
    public List<String[]> parse(String[] inputData) {
        if (inputData.length == 0) {
            throw new ValidationDataException("File is empty!");
        }
        List<String[]> parseCvsData = new ArrayList<>();
        for (String data : inputData) {
            String[] dataSplit = data.split(Constants.COMMA);
            if (dataSplit.length != Constants.MAX_SIZE_LINE) {
                throw new ValidationDataException("Not valid lines");
            }
            parseCvsData.add(data.split(","));
        }
        return parseCvsData;
    }
}
