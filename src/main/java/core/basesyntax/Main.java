package core.basesyntax;

import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.WriteServiceImpl;
import java.util.List;

public class Main {
    public static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    public static final String OUTPUT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> stringList = readerService.readFromFile(INPUT_FILE_NAME);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.report(stringList);
        WriteService writeService = new WriteServiceImpl();
        writeService.writeFile(OUTPUT_FILE_NAME, report);
    }
}
