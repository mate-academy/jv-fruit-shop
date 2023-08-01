package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.FruitTransactionsReportService;
import java.util.Map;

public class FruitTransactionsReportServiceImpl implements FruitTransactionsReportService {

    public static final String COMMA = ",";

    @Override
    public String createReport() {
        StorageDao storageDao = new StorageDaoImpl();
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
