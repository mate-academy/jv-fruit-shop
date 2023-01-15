package core.basesyntax;

import core.basesyntax.model.FruitTransactionDto;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvReportServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String INPUT_DATA_PATH = "src/main/resources/inputData.csv";
    private static final String OUTPUT_DATA_PATH = "src/main/resources/report.csv";
    private static final Map<String, Integer> FRUITS = new HashMap<>();

    public static void main(String[] args) {
        FileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        ReportService reportService = new CsvReportServiceImpl();
        List<FruitTransactionDto> fruitTransaction
                = fileReaderService.readDataFile(INPUT_DATA_PATH);
        TransactionHandler transactionHandler = new TransactionHandler();
        transactionHandler.handle(FRUITS, fruitTransaction);
        reportService.generateReport(FRUITS, OUTPUT_DATA_PATH);
    }
}
