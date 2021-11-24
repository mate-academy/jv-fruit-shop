package core.basesyntax.service.report;

import core.basesyntax.dao.FruitStorageDao;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEAD_OF_REPORT = "fruit,quantity";
    private static final String COMMA = ",";
    private final FruitStorageDao fruitStorageDao;

    public ReportServiceImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public String formReport() {
        StringBuilder reportBuilder = new StringBuilder(HEAD_OF_REPORT);
        for (Map.Entry<String, Integer> entry : fruitStorageDao.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue());
        }
        return reportBuilder.toString();
    }
}
