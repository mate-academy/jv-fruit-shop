package core.basesyntax.serviceimpl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.service.ReportHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitStoreReportHandler implements ReportHandler {
    private static final String REPORT_HEAD = "fruit,quantity";

    @Override
    public String makeReport(StorageDao storageDao) {
        Map<String, Integer> fruits = storageDao.getFruitsAmount();
        List<String> report = new ArrayList<>();
        report.add(REPORT_HEAD);
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return report.stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
