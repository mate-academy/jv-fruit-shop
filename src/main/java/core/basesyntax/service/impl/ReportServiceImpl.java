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
    public String makeReport() {
        StringBuilder output = new StringBuilder();
        if (dao.getAll().size() > 0) {
            output.append(FIRST_COLUMN_NAME + SEPARATOR
                    + SECOND_COLUMN_NAME + LINE_SEPARATOR + dao.getAll().entrySet().stream()
                    .map(n -> n.getKey() + SEPARATOR + n.getValue() + LINE_SEPARATOR)
                    .sorted()
                    .reduce("", (a, b) -> a + b))
                    .delete(output.length() - LINE_SEPARATOR.length(),
                    output.length());
        }
        return output.toString();
    }
}
