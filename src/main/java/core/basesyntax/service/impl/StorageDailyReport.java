package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StorageDailyReport implements ReportService {

    @Override
    public List<String> makeReport(Set<Map.Entry<Fruit, Integer>> storageStatus) {
        String headers = "fruit,quantity";
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
