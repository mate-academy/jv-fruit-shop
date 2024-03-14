package core.basesyntax;

import core.basesyntax.service.ReportGenerator;

public class MainApp {
    public static void main(String[] args) {
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateReport("report.csv", "new-report");
    }
}
