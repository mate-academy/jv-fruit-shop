package core.basesyntax.service.report;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMNS = "fruit,quantity";

    @Override
    public String createReport(Set<Map.Entry<Fruit, Integer>> entrySet) {
        StringBuilder report = new StringBuilder(COLUMNS);
        for (Map.Entry<Fruit, Integer> element : entrySet) {
            report.append(System.lineSeparator())
                    .append(element.getKey().getName())
                    .append(",")
                    .append(element.getValue());
        }
        return report.toString();
    }
}
