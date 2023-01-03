package core.basesyntax;

import core.basesyntax.service.impl.ProcessServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.CsvWriteServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String pathFromFile = "src/main/resources/file.csv";
        String pathToFile = "src/main/resources/report.csv";
        Map<String, Integer> fruitMap = new HashMap<>();
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        ProcessServiceImpl processService = new ProcessServiceImpl();
        ReportServiceImpl reportService = new ReportServiceImpl();
        CsvWriteServiceImpl writeService = new CsvWriteServiceImpl();
        String lines = readerService.readFromFile(pathFromFile);
        processService.getQuantityToMap(lines, fruitMap);
        String report = reportService.getReport(fruitMap);
        writeService.writeReport(pathToFile, report);
    }
}
