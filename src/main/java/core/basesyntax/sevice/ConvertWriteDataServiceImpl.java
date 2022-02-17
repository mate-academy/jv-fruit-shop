package core.basesyntax.sevice;

import java.util.Map;

public class ConvertWriteDataServiceImpl implements ConvertWriteDataService {
    @Override
    public String convertDataToFile(Map<String, Integer> fruitStorage) {
        StringBuilder kayValueString = new StringBuilder();

        for (Map.Entry<String, Integer> entries : fruitStorage.entrySet()) {
            kayValueString.append(entries.getKey()).append(",").append(entries.getValue())
                    .append(System.lineSeparator());
        }
        return new StringBuilder().append("fruit,quantity").append(System.lineSeparator())
                .append(kayValueString).toString().trim();
    }
}
