package core.basesyntax.service.impl;

import core.basesyntax.service.ParseDataService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParseDataServiceImpl implements ParseDataService {
    private static final String DELIMITER = ",";

    @Override
    public List<String[]> parseData(String data) {
        String[] splittedBySeparator = data.split(System.lineSeparator());
        List<String[]> lines = Arrays.stream(splittedBySeparator)
                .skip(1)
                .map(w -> w.split(DELIMITER))
                .collect(Collectors.toList());
        return lines;
    }
}
