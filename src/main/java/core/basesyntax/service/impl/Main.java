package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        ReportService reportService = new ReportServiceImpl();
        File dataFile = new File("input.csv");
        reportService.sendReport(dataFile);
    }
}
