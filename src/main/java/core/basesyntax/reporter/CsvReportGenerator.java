package core.basesyntax.reporter;

import core.basesyntax.dao.FruitStorageDao;
import java.util.Map;

public class CsvReportGenerator implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMA = ",";
    private final FruitStorageDao fruitStorageDao;

    public CsvReportGenerator(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public String generateReport() {
        StringBuilder builder = new StringBuilder();
        Map<String, Integer> fruitMap = fruitStorageDao.getAll();
        builder.append(HEADER);
        for (Map.Entry<String, Integer> entry : fruitMap.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMA)
                    .append(fruitStorageDao.getQuantity(entry.getKey()));
        }
        return builder.toString();
    }
}
