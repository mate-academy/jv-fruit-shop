package core.basesyntax;

import core.basesyntax.service.ConvertDataService;
import core.basesyntax.service.ProcessService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreationService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ConvertDataServiceCsvImpl;
import core.basesyntax.service.impl.ProcessServiceCsvImpl;
import core.basesyntax.service.impl.ReaderServiceCsvImpl;
import core.basesyntax.service.impl.ReportCreationServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    public static final String CSV_FILE_TO_READ = "src/grocery.csv";
    public static final String CSV_FILE_TO_WRITE = "src/report.csv";

    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceCsvImpl();
        ConvertDataService converter = new ConvertDataServiceCsvImpl();
        ProcessService processService = new ProcessServiceCsvImpl();
        ReportCreationService reportCreationService = new ReportCreationServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        String readData = reader.readData(CSV_FILE_TO_READ);
        List<String> convertedData = converter.convert(readData);
        processService.processInfo(convertedData);
        String report = reportCreationService.createReport();
        writerService.writeReport(report, CSV_FILE_TO_WRITE);
    }
}
