package core.basesyntax.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitStoreReportHandler implements ReportHandler {
    private static final String REPORT_HEARD = "fruit,quantity";
    private final StorageDao storageDao;

    public FruitStoreReportHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String makeReport() {
        if (storageDao == null) {
            throw new RuntimeException("Can't call method 'makeReport' if storageDao is null");
        }
        Map<String, Integer> fruits = storageDao.getAll();
        List<String> report = new ArrayList<>();
        report.add(REPORT_HEARD);
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return report.stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
