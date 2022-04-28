package core.basesyntax;

import core.basesyntax.service.ReportService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParserDataService;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ParserDataServiceImpl;

import java.util.List;

public class ShopApp {
    private static final String FILE_NAME = "src/main/resources/inputFile.csv";
    private static final String REPORT_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReaderService read = new FileReaderServiceImpl();
        List<String> listWithFile = read.readWithFile(FILE_NAME);

        ParserDataService parseData = new ParserDataServiceImpl();
        parseData.parsedWithFile(listWithFile);

        ReportService createReport = new ReportServiceImpl();
        List<String> resultReport = createReport.generatedReport();

        FileWriterService write = new FileWriterServiceImpl();
        write.writeToFile(REPORT_NAME, resultReport);
    }
}
