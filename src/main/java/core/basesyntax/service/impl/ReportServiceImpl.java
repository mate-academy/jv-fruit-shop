package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {

    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private FruitStorageDao storageDao = new FruitStorageDaoImpl();

    @Override
    public String createReport() {
        Map<String, Integer> reportMap = storageDao.getAll();
        StringBuilder report = new StringBuilder(HEADER)
                .append(LINE_SEPARATOR);
        for (Map.Entry<String, Integer> entry : reportMap.entrySet()) {
            report.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return report.toString();
    }
}
