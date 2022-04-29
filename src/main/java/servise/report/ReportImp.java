package servise.report;

import db.Storage;
import java.util.List;

public class ReportImp implements Report {
    @Override
    public String report(List<String> keys) {
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (String key : keys) {
            report.append(key)
                    .append(",")
                    .append(Storage.MapDataBaseReport.get(key))
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
