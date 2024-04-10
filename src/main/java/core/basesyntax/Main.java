package core.basesyntax;

import java.io.File;
import java.util.Map;
import service.FileReaderService;
import service.FileWriterService;
import service.ReportService;
import service.impl.FileReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.ReportWriterService;

public class Main {
    private static final String PATH_TO_FILE = "src/main/java/resources/File.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        FileWriterService fileWriterService = new ReportWriterService();
        Map<String, Integer> report = reportService
                .createReport(fileReaderService
                        .readFromFile(new File(PATH_TO_FILE)));
        fileWriterService.writeToFile(report);
    }
}
