package core.basesyntax.report;

import java.util.Map;
import java.util.stream.Collectors;

public class ReportDataImpl implements ReportData {
    private static final String TITLE = "fruit,quantity";

    @Override
    public String createDataReport(Map<String, Integer> values) {
        String collect = values.entrySet().stream()
                .map(val -> val.getKey() + "," + val.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        StringBuilder builder = new StringBuilder(TITLE).append("\n").append(collect);
        return builder.toString();
    }
}
