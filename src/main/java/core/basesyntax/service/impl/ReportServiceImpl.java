package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,balance";
    private static final String COMMA = ",";
    private StorageDao fruitStorageDao = new StorageDaoImpl();

    @Override
    public StringBuilder makeReport() {
        StringBuilder reportMaker = new StringBuilder(REPORT_TITLE);
        for (Map.Entry<Fruit, Integer> element : fruitStorageDao.getAll()) {
            reportMaker.append(System.lineSeparator())
                    .append(element.getKey().getName())
                    .append(COMMA)
                    .append(element.getValue());
        }
        return reportMaker;
    }
}
