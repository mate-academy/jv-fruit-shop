package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvReportServiceImpl;
import java.util.List;

public class Main {

    private static final String INPUT_DATA_PATH = "src/main/resources/inputData.csv";
    private static final String OUTPUT_DATA_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        ReportService reportService = new CsvReportServiceImpl();
        List<FruitTransaction> fruitTransaction
                = fileReaderService.readDataFile(INPUT_DATA_PATH);
        TransactionHandler transactionHandler = new TransactionHandler();
        transactionHandler.handle(Storage.FRUITS, fruitTransaction);
        reportService.generateReport(Storage.FRUITS, OUTPUT_DATA_PATH);
    }
}
