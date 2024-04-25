package service.impl;

import dao.FruitDao;
import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private final FruitDao fruitDao;
    private final StringBuilder reportBuilder = new StringBuilder();

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        reportBuilder.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry : fruitDao.getEntries()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey() + "," + entry.getValue());
        }
        return reportBuilder.toString();
    }
}
