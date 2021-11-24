package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_LINE = "fruit,quantity";

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add(FIRST_LINE);
        StringBuilder reportBuilder = new StringBuilder();
        for (Map.Entry<Fruit,Integer> entry : Storage.storage.entrySet()) {
            reportBuilder.append(entry.getKey()).append(",").append(entry.getValue());
            report.add(reportBuilder.toString());
            reportBuilder.setLength(0);
        }
        return report;
    }
}
