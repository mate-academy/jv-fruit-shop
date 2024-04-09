package core.basesyntax;

import java.io.File;
import java.util.List;
import model.FruitTransaction;
import service.FileReaderService;
import service.FileWriterService;
import service.ReportService;
import service.impl.FileReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.ReportWriterService;

public class Main {
    private static final FileReaderService FILE_READER_SERVICE = new FileReaderServiceImpl();
    private static final ReportService REPORT_SERVICE = new ReportServiceImpl();
    private static final FileWriterService FILE_WRITER_SERVICE = new ReportWriterService();
    private static final String PATH_TO_FILE = "src/main/java/resources/File.csv";

    public static void main(String[] args) {
        List<FruitTransaction> fruitTransactions = FILE_READER_SERVICE
                .readFromFile(new File(PATH_TO_FILE));
        List<String> report = REPORT_SERVICE.createReport(fruitTransactions);
        FILE_WRITER_SERVICE.writeToFile(report);
    }
}
