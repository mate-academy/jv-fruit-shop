package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportCreatorService;
import java.util.Map;

public class CsvReportCreatorServiceImpl implements ReportCreatorService {
    private static final String TITLE_STRING = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private final FruitDao fruitDao;

    public CsvReportCreatorServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        Map<String, Integer> fruitStorageState = fruitDao.getStorageState();
        StringBuilder kayValueString = new StringBuilder();
        kayValueString.append(TITLE_STRING).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entries : fruitStorageState.entrySet()) {
            kayValueString.append(entries.getKey()).append(SEPARATOR)
                    .append(entries.getValue()).append(System.lineSeparator());
        }
        return kayValueString.toString().trim();
    }
}
