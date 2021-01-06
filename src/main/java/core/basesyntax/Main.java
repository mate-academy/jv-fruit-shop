package core.basesyntax;

import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.work.with.file.ReadInformationFromFile;
import core.basesyntax.service.work.with.file.ReadInformationFromFileImpl;
import core.basesyntax.service.work.with.file.Report;
import core.basesyntax.service.work.with.file.ReportImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fromFileName = "database.csv";
        String toFileName = "Report";
        FruitService fruitService = new FruitServiceImpl();
        ReadInformationFromFile readInformationFromFile = new ReadInformationFromFileImpl();

        List<String> allLinesFromFile = readInformationFromFile.getAllLines(fromFileName);
        fruitService.addNewFruit(allLinesFromFile);

        Report report = new ReportImpl();
        report.createReport(allLinesFromFile);
        String reportString = report.writeReport(allLinesFromFile);
        report.writeReportToFile(reportString, toFileName);
    }
}
