package core.basesyntax.service.Impl;

import core.basesyntax.service.ConvertWriteDataService;

import java.util.Map;

public class ConvertWriteDataServiceImpl implements ConvertWriteDataService {
    private static final String TITLE_STRING = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String convertDataToFile(Map<String, Integer> fruitStorage) {
        StringBuilder kayValueString = new StringBuilder();
        for (Map.Entry<String, Integer> entries : fruitStorage.entrySet()) {
            kayValueString.append(entries.getKey()).append(SEPARATOR)
                    .append(entries.getValue()).append(System.lineSeparator());
        }
        return new StringBuilder().append(TITLE_STRING).append(System.lineSeparator())
                .append(kayValueString).toString().trim();
    }
}
