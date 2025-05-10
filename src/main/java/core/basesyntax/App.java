package core.basesyntax;

import core.basesyntax.data.file.FileReader;
import core.basesyntax.data.file.FileWriter;
import core.basesyntax.data.file.impl.FileReaderImpl;
import core.basesyntax.data.file.impl.FileWriterImpl;
import core.basesyntax.data.storage.Storage;
import core.basesyntax.data.storage.StorageImpl;
import core.basesyntax.model.FruitResultingRow;
import core.basesyntax.model.FruitTransactionRow;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.parser.FileService;
import core.basesyntax.service.parser.FileServiceImpl;
import java.util.List;

public class App {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        FileWriter csvWriter = new FileWriterImpl(OUTPUT_FILE_PATH);
        FileReader csvReader = new FileReaderImpl(INPUT_FILE_PATH);
        FileService fileService = new FileServiceImpl();
        Storage<FruitTransactionRow> storage = new StorageImpl();

        List<String> readLinesFromCsv = csvReader.readAll();
        List<FruitTransactionRow> transactions = fileService.parseTransactions(readLinesFromCsv);
        storage.updateTransactionHistory(transactions);

        List<FruitResultingRow> report =
                reportGenerator.generateReport(storage.getTransactionHistory());

        List<String> reportAsCsvFileLines = fileService.reportObjectsToStrings(report);
        csvWriter.writeAll(reportAsCsvFileLines);
    }
}
