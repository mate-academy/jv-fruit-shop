package service.impl;

import db.Storage;
import service.ReportCreator;

public class FruitReportCreator implements ReportCreator {
    public static final String SEPARATOR_NEW_LINE = "\n";
    public static final String SEPARATOR_COMA = ",";
    public static final String REPORT_HEADER = "fruit, quantity";
    private final Storage fruitStorage;

    public FruitReportCreator(Storage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append(REPORT_HEADER + SEPARATOR_NEW_LINE);
        for (String s : fruitStorage.getAllItems()) {
            report.append(s).append(SEPARATOR_COMA)
                    .append(fruitStorage.getQuantity(s))
                    .append(SEPARATOR_NEW_LINE);
        }
        return report.toString();
    }
}
