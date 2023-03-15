package core.basesyntax.service.impl;

import core.basesyntax.service.ConverterDataService;
import java.util.ArrayList;
import java.util.List;

public class ConverterDataServiceImpl implements ConverterDataService {
    @Override
    public List<String> convert(String data) {
        List<String> convertedData = new ArrayList<>(List.of(data.split(System.lineSeparator())));
        convertedData.remove(0);
        return convertedData;
    }
}
