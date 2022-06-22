package servise.impl;

import dao.ItemDao;
import java.util.Map;
import servise.ReportService;

public class ReportServiceImpl implements ReportService {
    private final ItemDao itemDao;

    public ReportServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> record : itemDao.readAll()) {
            report.append(System.lineSeparator())
                    .append(record.getKey())
                    .append(",")
                    .append(record.getValue());
        }
        return report.toString();
    }
}
