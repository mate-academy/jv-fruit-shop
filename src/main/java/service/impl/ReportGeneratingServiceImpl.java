package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import service.ReportGeneratingService;

public class ReportGeneratingServiceImpl implements ReportGeneratingService {
    private static final String FIRST_LINE_OF_REPORT = "fruit,quantity";
    private static final String CSV_SEPARATOR = ",";

    @Override
    public List<String> createReport(List<Fruit> db) {
        List<String> report = new ArrayList<>();
        report.add(FIRST_LINE_OF_REPORT);
        for (Fruit fruit : db) {
            report.add(fruit.getFruitType() + CSV_SEPARATOR + fruit.getQuantity());
        }
        return report;
    }
}
