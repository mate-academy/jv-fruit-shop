package core.basesyntax;

import core.basesyntax.service.report.Report;
import core.basesyntax.service.report.ReportImpl;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "src/main/resources/inputData.csv";
        String reportFileName = "src/main/resources/report.csv";
        Report report = new ReportImpl();
        report.createReport(inputFileName, reportFileName);
    }
}
