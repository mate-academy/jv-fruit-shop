package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.*;

import java.util.List;

public class Main {
    private static final String INPUT_DATA_PATH = "src/main/resources/inputData.csv";
    private static final String OUTPUT_DATA_PATH = "src/main/resources/report.csv";


    public static void main(String[] args) {
        FileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        //ReportService reportService = new CsvReportServiceImpl();
        List<FruitTransaction> fruitTransactions
                = fileReaderService.readFromFile(INPUT_DATA_PATH);
        FruitTransactionHandlerImpl fruitTransactionHandlerImpl = new FruitTransactionHandlerImpl();
        fruitTransactionHandlerImpl.handle(Storage.FRUITS, fruitTransactions);
        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.generate(Storage.FRUITS);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(OUTPUT_DATA_PATH,report);
        //reportService.generateReport(Storage.FRUITS, OUTPUT_DATA_PATH);
    }
}
