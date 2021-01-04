package core.basesyntax;

import core.basesyntax.service.work.with.file.Report;
import core.basesyntax.service.work.with.file.ReportImpl;

public class Main {
    public static void main(String[] args) {
        Report report = new ReportImpl();
        report.writeReportToFile("database.csv");
        report.writeReportToFile("database1.csv");
        System.out.println("Success");
    }
}
