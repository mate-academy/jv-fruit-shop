package core.basesyntax.services.impl;

import core.basesyntax.exception.ValidationDataException;
import core.basesyntax.services.ParseCsvService;
import core.basesyntax.util.ConstantsForCsvParse;
import java.util.ArrayList;
import java.util.List;

public class ParseCsvServiceImpl implements ParseCsvService {
    @Override
    public List<String[]> parse(String[] inputData) {
        if (inputData == null) {
            throw new ValidationDataException("Input data in parse service can't be null");
        }
        if (inputData.length == 0) {
            throw new ValidationDataException("Input data in parse service can't be empty");
        }

        List<String[]> parseCvsData = new ArrayList<>();
        for (String data : inputData) {
            String[] dataSplit = data.split(ConstantsForCsvParse.COMMA);
            if (dataSplit.length != ConstantsForCsvParse.MAX_SIZE_LINE) {
                throw new ValidationDataException("Not valid lines");
            }
            parseCvsData.add(dataSplit);
        }
        return parseCvsData;
    }
}
