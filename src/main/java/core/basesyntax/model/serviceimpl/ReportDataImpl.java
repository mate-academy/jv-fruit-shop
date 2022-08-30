package core.basesyntax.model.serviceimpl;

import core.basesyntax.model.service.ReportData;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportDataImpl implements ReportData {
    private static final String TITLE = "fruit,quantity";

    @Override
    public String createDataReport(Set<Map.Entry<String, Integer>> entries) {
        StringBuilder builder = new StringBuilder(TITLE).append("\n");
        String collect = entries.stream()
                        .map(e -> e.getKey() + "," + e.getValue())
                        .collect(Collectors.joining(System.lineSeparator()));
        return builder.append(collect).toString();
    }
}
