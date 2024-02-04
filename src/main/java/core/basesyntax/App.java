package core.basesyntax;

import core.basesyntax.data.FileService;
import core.basesyntax.data.FileServiceImpl;
import core.basesyntax.data.csv.FileReader;
import core.basesyntax.data.csv.FileWriter;
import core.basesyntax.data.csv.impl.CsvFileReaderImpl;
import core.basesyntax.data.csv.impl.CsvFileWriterImpl;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;

public class App {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";
    private static final String OUTPUT_FILE_HEADER_ROW = "fruit,quantity";

    public static void main(String[] args) {
        ReportGenerator reportGenerator = new ReportGeneratorImpl();

        FileWriter csvWriter = new CsvFileWriterImpl(OUTPUT_FILE_PATH, OUTPUT_FILE_HEADER_ROW);
        FileReader csvReader = new CsvFileReaderImpl(INPUT_FILE_PATH);
        FileService fileService = new FileServiceImpl(csvWriter, csvReader);

        var transactionHistory = fileService.getTransactions();
        var report = reportGenerator.generateReport(transactionHistory);

        fileService.saveReport(report);
    }
}
