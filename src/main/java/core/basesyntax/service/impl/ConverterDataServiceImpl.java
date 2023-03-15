package core.basesyntax.service.impl;

import core.basesyntax.service.ConverterDataService;

import java.util.ArrayList;
import java.util.List;

public class ConverterDataServiceImpl implements ConverterDataService {
    private static final String LINE_SEPARATOR = ",";
    @Override
    public List<String[]> convert(List<String> data) {
        List<String[]> convertedData = new ArrayList<>();
        for (String s : data) {
            String[] splittedString = s.split(LINE_SEPARATOR);
            convertedData.add(splittedString);
        }
        return convertedData;
    }
}
