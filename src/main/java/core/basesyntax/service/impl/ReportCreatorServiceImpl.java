package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.service.ReportCreatorService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String CSV_REPORT_TITLE = "fruit,quantity";
    private static final int TITLE_INDEX = 0;
    private static final String FRUIT_TRANSACTION_SEPARATOR = ",";

    private static final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public List<String> create() {
        Map<String, Integer> reportMap = storageDao.getAll();
        List<String> dailyReport = reportMap
                .entrySet()
                .stream()
                .map(entry -> entry.getKey()
                        + FRUIT_TRANSACTION_SEPARATOR
                        + entry.getValue())
                .collect(Collectors.toList());
        dailyReport.add(TITLE_INDEX, CSV_REPORT_TITLE);
        return dailyReport;
    }
}
