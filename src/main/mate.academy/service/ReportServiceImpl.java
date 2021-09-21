package service;

import model.Fruit;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_ROW = "fruit,quantity";

    @Override
    public String createReport(Map<Fruit, Integer> reportMap) {
        StringBuilder stringBuilder = new StringBuilder(FIRST_ROW)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> report : reportMap.entrySet()) {
            stringBuilder.append(report.getKey())
                    .append(",")
                    .append(report.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}