package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {

    private static final String COMMA = ",";
    private FruitStorageDao storageDao = new FruitStorageDaoImpl();

    @Override
    public String createReport() {
        Map<String, Integer> reportMap = storageDao.getAll();
        StringBuilder report = new StringBuilder("fruit,quantity")
                .append(System.lineSeparator());
        for (Map.Entry<String,Integer> entry : reportMap.entrySet()) {
            report.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
