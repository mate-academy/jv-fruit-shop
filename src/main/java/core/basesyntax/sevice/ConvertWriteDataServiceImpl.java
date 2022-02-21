package core.basesyntax.sevice;

import java.util.Map;

public class ConvertWriteDataServiceImpl implements ConvertWriteDataService {
    private static final String TITLE_ROW = "fruit,quantity";
    private static final String SEPARATING_SIGN = ",";

    @Override
    public String convertDataToFile(Map<String, Integer> fruitStorage) {
        StringBuilder kayValueString = new StringBuilder();

        for (Map.Entry<String, Integer> entries : fruitStorage.entrySet()) {
            kayValueString.append(entries.getKey()).append(SEPARATING_SIGN)
                    .append(entries.getValue()).append(System.lineSeparator());
        }
        return new StringBuilder().append(TITLE_ROW).append(System.lineSeparator())
                .append(kayValueString).toString().trim();
    }
}
