package core.basesyntax.reportgenerator;

import core.basesyntax.dao.FruitsDao;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_FIRST_LINE = "fruit,quantity";
    private final FruitsDao dao;

    public ReportGeneratorImpl(FruitsDao dao) {
        this.dao = dao;
    }

    @Override
    public String getReport() {
        return createReport();
    }

    private String createReport() {
        StringBuilder sb = new StringBuilder(REPORT_FIRST_LINE);
        dao.getAll()
                .forEach((k, v) ->
                        sb.append(System.lineSeparator()).append(k).append(",").append(v)
                );

        return sb.toString();
    }
}
