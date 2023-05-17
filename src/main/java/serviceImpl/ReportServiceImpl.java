package serviceImpl;

import db.StorageImpl;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        StorageImpl.fruitStorage.forEach((key, value) -> report
                .append(System.lineSeparator())
                .append(key)
                .append(",")
                .append(value));
        return report.toString();
    }
}