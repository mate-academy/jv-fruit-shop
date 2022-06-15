package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String FIRST_COLUMN_NAME = "fruit";
    private static final String SECOND_COLUMN_NAME = "quantity";
    private FruitDao dao;

    public ReportServiceImpl(FruitDao dao) {
        this.dao = dao;
    }

    @Override
    public String writeReport() {
        StringBuilder output = new StringBuilder(FIRST_COLUMN_NAME + SEPARATOR
                 + SECOND_COLUMN_NAME + LINE_SEPARATOR + dao.getAll().entrySet().stream()
                .map(n -> n.getKey() + SEPARATOR + n.getValue() + LINE_SEPARATOR)
                .reduce("", (a, b) -> a + b));
        return output.delete(output.length() - LINE_SEPARATOR.length(),
                output.length()).toString();
    }
}
