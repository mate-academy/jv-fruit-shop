package core.basesyntax;

import core.basesyntax.service.work.with.file.ReadInformationFromFile;
import core.basesyntax.service.work.with.file.ReadInformationFromFileImpl;
import core.basesyntax.service.work.with.file.Report;
import core.basesyntax.service.work.with.file.ReportImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fromFileName = "database.csv";
        String toFileName = "report.csv";
        ReadInformationFromFile readInformationFromFile = new ReadInformationFromFileImpl();
        List<String> allLinesFromFile = readInformationFromFile.getAllLines(fromFileName);
        Report report = new ReportImpl();
        String reportString = report.writeReportToString(allLinesFromFile);
        report.writeReportToFile(reportString, toFileName);
    }
}
