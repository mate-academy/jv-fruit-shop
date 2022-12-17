package service.impl;

import java.util.Map;
import model.Fruit;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String INFORM_LINE = "fruit,quantity";

    @Override
    public String createReport(Map<Fruit, Integer> fruits) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(INFORM_LINE);
        fruits.forEach((fruit, amount) -> reportBuilder.append(System.lineSeparator())
                .append(fruit.getName()).append(",").append(amount));
        return reportBuilder.toString();
    }

}
