package core.basesyntax;

import core.basesyntax.service.FormaterService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.FormaterServiceImpl;
import core.basesyntax.service.impl.ProcessServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;

public class Main {
    public static final String PATH_TO_INPUT_FILE = "src/main/java/resources/input.csv";
    public static final String PATH_TO_REPORT_FILE = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        ReaderService readerService = new CsvReaderServiceImpl();
        FormaterService formaterService = new FormaterServiceImpl();
        ProcessServiceImpl processService = new ProcessServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        processService.manageTransactions(
                formaterService.format(
                        readerService.read(PATH_TO_INPUT_FILE)));
        writerService.writeToFile(reportService.generateReport(), PATH_TO_REPORT_FILE);
    }
}
