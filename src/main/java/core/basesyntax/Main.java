package core.basesyntax;
import core.basesyntax.service.*;

import java.io.IOException;
import java.util.List;

public class Main {
    private static String INPUT_FILE = "src/main/resources/report.csv";
    private static String REPORT_FILE = "src/main/resources/balance.csv";

    public static void main(String[] args) throws IOException {
        FileService fileService = new FileServiceImpl();
        TransactionConverter transactionConverter = new TransactionConverterImpl();
        List<String> fileData = fileService.readFile(INPUT_FILE);
        List<FruitTransaction> fruitTransactions = transactionConverter.convert(fileData);
        TransactionProcessor transactionProcessor = new TransactionProcessorImpl();
        transactionProcessor.processTransactions(fruitTransactions);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        fileService.writeToFile(REPORT_FILE, report);
    }
}
