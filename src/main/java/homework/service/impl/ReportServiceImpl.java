package homework.service.impl;

import homework.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    public static final String HEADER = "fruit,quantity";

    @Override
    public String report(Map<String, Integer> dataBase) {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : dataBase.entrySet()) {
            report.append(fruit.getKey())
                    .append(",")
                    .append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }

}
