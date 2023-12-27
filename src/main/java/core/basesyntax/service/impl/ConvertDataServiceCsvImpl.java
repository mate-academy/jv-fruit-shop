package core.basesyntax.service.impl;

import core.basesyntax.service.ConvertDataService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertDataServiceCsvImpl implements ConvertDataService {
    private static final Integer OFFSET = 1;
    private final List<String> convertedData = new ArrayList<>();

    @Override
    public List<String> convert(String data) {
        String[] splitedData = data.split(System.lineSeparator());
        convertedData.addAll(Arrays.asList(splitedData).subList(OFFSET, splitedData.length));
        return convertedData;
    }
}
