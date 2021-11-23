package service.impl;

import java.util.List;
import model.Fruit;
import service.CreateReport;

public class CreateReportImpl implements CreateReport {
    private static final String TITLE_TEXT = "fruit,quantity";

    public String createReport(List<Fruit> fruits) {
        StringBuilder sb = new StringBuilder();
        sb.append(TITLE_TEXT).append(System.lineSeparator());
        for (Fruit fruit : fruits) {
            sb.append(fruit.getName()).append(",")
                    .append(fruit.getQuantity())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
