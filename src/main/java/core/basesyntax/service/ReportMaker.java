package core.basesyntax.service;

import core.basesyntax.model.Fruit;

import java.util.List;

public class ReportMaker {
    private static final String REPORT_HEAD = "fruit,quantity";
    private static final String SEPARATOR = ",";

    public String make(List<Fruit> data){
        StringBuilder report = new StringBuilder(REPORT_HEAD).append(System.lineSeparator());
        for (Fruit fruit : data) {
            report.append(fruit.getType()).append(SEPARATOR).append(fruit.getAmount()).append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
