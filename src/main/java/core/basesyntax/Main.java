package core.basesyntax;

import core.basesyntax.services.ReportService;
import core.basesyntax.services.ReportServiceImpl;

public class Main {
    public static void main(String[] args) {
        ReportService reportService = new ReportServiceImpl();
        reportService.createReport("DB.csv", "REPORT.csv");
    }
}
