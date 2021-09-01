package core.basesyntax.services;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_REPORT = "fruit, quantity";

    @Override
    public List<String> createReport(Map<Fruit, Integer> mapQuantityFruit) {
        List<String> report = new ArrayList<>();
        report.add(TITLE_REPORT);
        report.add(System.lineSeparator());
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> entry : mapQuantityFruit.entrySet()) {
            builder.append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        report.add(builder.toString().trim());
        return report;
    }
}
