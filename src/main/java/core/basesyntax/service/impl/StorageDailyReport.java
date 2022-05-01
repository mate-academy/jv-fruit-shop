package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import core.basesyntax.storage.StorageDao;
import core.basesyntax.storage.StorageDaoImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StorageDailyReport implements ReportService {
    private final StorageDao storageDao;

    public StorageDailyReport() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public List<String> makeReport() {
        String headers = "fruit,quantity";
        Set<Map.Entry<Fruit, Integer>> storageStatus = storageDao.getAll();
        List<String> report = new ArrayList<>();
        StringBuilder reportBuilder = new StringBuilder();
        report.add(headers);

        for (Map.Entry<Fruit, Integer> data : storageStatus) {
            String fruit = data.getKey().getName();
            Integer quantity = data.getValue();
            reportBuilder.append(fruit).append(",").append(quantity);
            report.add(reportBuilder.toString());
            reportBuilder.setLength(0);
        }
        return report;
    }
}
