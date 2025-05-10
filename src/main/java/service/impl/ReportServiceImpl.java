package service.impl;

import dao.FruitDao;
import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private final FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : fruitDao.getEntries()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey() + "," + entry.getValue());
        }
        return reportBuilder.toString();
    }
}
