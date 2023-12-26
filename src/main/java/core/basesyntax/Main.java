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
    public static void main(String[] args) {
        String csvFileToRead = "src/grocery.csv";
        String csvFileToWrite = "src/report.csv";
        ReaderService reader = new ReaderServiceCsvImpl();
        ConvertDataService converter = new ConvertDataServiceCsvImpl();
        ProcessService processService = new ProcessServiceCsvImpl();
        ReportCreationService reportCreationService = new ReportCreationServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        String readedData = reader.readData(csvFileToRead);
        List<String> convertedData = converter.convert(readedData);
        processService.processInfo(convertedData);
        String report = reportCreationService.createReport();
        writerService.writeReport(report, csvFileToWrite);
    }
}
