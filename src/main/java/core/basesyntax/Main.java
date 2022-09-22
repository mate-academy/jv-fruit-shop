package core.basesyntax;

import core.basesyntax.service.report.ReportFruitsService;
import core.basesyntax.service.report.ReportFruitsServiceImpl;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input_file";
    private static final String REPORT_FILE = "src/main/resources/report_file";

    public static void main(String[] arg) {
        ReportFruitsService reportFruitsService = new ReportFruitsServiceImpl();
        reportFruitsService.report(INPUT_FILE,REPORT_FILE);
    }
}
