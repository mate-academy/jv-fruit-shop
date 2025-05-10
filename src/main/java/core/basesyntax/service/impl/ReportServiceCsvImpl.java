package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceCsvImpl implements ReportService {
    private static final String FIRST_LINE = "fruit,quantity\n";
    private final FruitStorageDao fruitStorageDao;

    public ReportServiceCsvImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FIRST_LINE);
        Map<String, Integer> map = fruitStorageDao.getAllAsMap();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }
}
