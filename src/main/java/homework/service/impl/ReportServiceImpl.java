package homework.service.impl;

import homework.model.Fruit;
import homework.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    public static final String HEADER = "fruit,quantity";

    @Override
    public String report(Map<Fruit, Integer> dataBase) {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> fruit : dataBase.entrySet()) {
            report.append(fruit.getKey().getFruit())
                    .append(",")
                    .append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
