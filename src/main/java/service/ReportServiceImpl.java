package service;

import dao.FruitDao;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_COLUMN_NAME = "fruit";
    private static final String SECOND_COLUMN_NAME = "quantity";
    private FruitDao dao;

    public ReportServiceImpl(FruitDao dao) {
        this.dao = dao;
    }

    @Override
    public String makeReport() {
        StringBuilder reportBuilder = new StringBuilder();
        if (dao.getAll().size() > 0) {
            reportBuilder.append(FIRST_COLUMN_NAME + ","
                            + SECOND_COLUMN_NAME + System.lineSeparator()
                            + dao.getAll().entrySet().stream()
                            .map(n -> n.getKey() + "," + n.getValue() + System.lineSeparator())
                            .sorted()
                            .reduce("", (a, b) -> a + b))
                    .delete(reportBuilder.length() - System.lineSeparator().length(),
                            reportBuilder.length());
        }
        return reportBuilder.toString();
    }
}
