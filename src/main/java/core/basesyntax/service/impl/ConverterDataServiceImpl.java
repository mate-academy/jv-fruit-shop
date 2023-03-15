package core.basesyntax.service.impl;

import core.basesyntax.service.ConverterDataService;

import java.util.ArrayList;
import java.util.List;

public class ConverterDataServiceImpl implements ConverterDataService {
    @Override
    public List<String[]> convert(List<String> data) {
        List<String[]> convertedData = new ArrayList<>();
        for (String s : data) {
            String[] splittedString = s.split(","); //TODO: Magick Number
            convertedData.add(splittedString);
        }
        return convertedData;
    }
}
