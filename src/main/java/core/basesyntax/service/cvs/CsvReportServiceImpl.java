package core.basesyntax.service.cvs;

import java.util.Map;
import java.util.stream.Collectors;

public class CsvReportServiceImpl implements CsvReportService {

    @Override
    public String getReport(Map<String, Integer> fruits) {
        return fruits.entrySet().stream()
                .map(z -> z.getKey() + "," + z.getValue())
                .collect(Collectors.joining(System.lineSeparator(), "fruit,quantity\n", ""));
    }
}
