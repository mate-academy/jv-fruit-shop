package mate.academy;

import java.util.List;
import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.service.FileReaderService;
import mate.academy.service.FileWriterService;
import mate.academy.service.TransactionService;
import mate.academy.service.impl.CsvFileReaderServiceImpl;
import mate.academy.service.impl.CsvFileWriterServiceImpl;
import mate.academy.service.impl.TransactionServiceImpl;

public class Main {
    private static final String FILE_NAME = "database.csv";
    private static final String FILE_REPORT_NAME = "report.csv";

    public static void main(String[] args) {

        FileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        List<FruitTransaction> fruitTransactions = fileReaderService.readFromFile(FILE_NAME);

        TransactionService transactionService = new TransactionServiceImpl();
        Map<String, Integer> fruitsMap = transactionService.processedData(fruitTransactions);

        FileWriterService fileWriterService = new CsvFileWriterServiceImpl();
        fileWriterService.write(fruitsMap, FILE_REPORT_NAME);
    }
}
