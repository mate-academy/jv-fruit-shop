package core.basesyntax.service.report;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMNS = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String createReport(Set<Map.Entry<Fruit, Integer>> entrySet) {
        StringBuilder report = new StringBuilder(COLUMNS);
        for (Map.Entry<Fruit, Integer> element : entrySet) {
            report.append(LINE_SEPARATOR)
                    .append(element.getKey().getName())
                    .append(",")
                    .append(element.getValue());
        }
        return report.toString();
    }
}
