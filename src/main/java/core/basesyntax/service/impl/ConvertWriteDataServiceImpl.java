package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ConvertWriteDataService;
import java.util.Map;

public class ConvertWriteDataServiceImpl implements ConvertWriteDataService {
    private static final String TITLE_STRING = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private Map<String, Integer> fruitStorageState;
    @Override
    public String getReport() {
        fruitStorageState = new FruitDaoImpl().getStorageState();
        StringBuilder kayValueString = new StringBuilder();
        for (Map.Entry<String, Integer> entries : fruitStorageState.entrySet()) {
            kayValueString.append(entries.getKey()).append(SEPARATOR)
                    .append(entries.getValue()).append(System.lineSeparator());
        }
        return new StringBuilder().append(TITLE_STRING).append(System.lineSeparator())
                .append(kayValueString).toString().trim();
    }
}
