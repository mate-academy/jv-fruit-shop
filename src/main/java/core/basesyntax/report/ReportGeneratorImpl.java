package core.basesyntax.report;

import core.basesyntax.dao.FruitDao;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String DELIMITER = ",";
    private final FruitDao fruitDao;

    public ReportGeneratorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        String dataRows = fruitDao.getAll().entrySet().stream()
                .map(entry ->
                        entry.getKey() + DELIMITER + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));

        return REPORT_HEADER + System.lineSeparator()
                + dataRows
                + (dataRows.isEmpty() ? "" : System.lineSeparator());
    }
}
