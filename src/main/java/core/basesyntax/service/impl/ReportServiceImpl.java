package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public record ReportServiceImpl(FruitDao fruitDao)
        implements ReportService {

    private static final String HEADER = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String createReport() {
        Map<String, Integer> storage = fruitDao.getStorage();

        String report = storage
                .entrySet()
                .stream()
                .map(entry -> entry.getKey()
                        + COMMA_SEPARATOR
                        + entry.getValue())
                .collect(Collectors.joining(LINE_SEPARATOR,
                        HEADER + LINE_SEPARATOR,
                        ""));
        return report;
    }
}
