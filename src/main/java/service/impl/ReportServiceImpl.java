package service.impl;

import dao.FruitDao;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_FIRST_LINE = "fruit,quantity";
    private final FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(REPORT_FIRST_LINE);
        fruitDao.getAll().forEach((fruit, quantity) ->
                report.append(System.lineSeparator())
                .append(fruit.getName())
                .append(",")
                .append(quantity));
        return report.toString();
    }
}
