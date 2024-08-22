package service.impl;

import dao.FruitDao;
import java.util.Map;
import java.util.Set;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String COLUMNS_NAME = "fruit,quantity";
    private final FruitDao fruitDao;

    public ReportGeneratorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        Set<Map.Entry<String, Integer>> data = fruitDao.getAllEntries();
        StringBuilder report = new StringBuilder();
        report.append(COLUMNS_NAME).append(System.lineSeparator());
        for (Map.Entry<String, Integer> line : data) {
            report.append(line.getKey()).append(",").append(line.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
