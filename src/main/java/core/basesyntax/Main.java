package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionHandlerImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import java.util.List;

public class Main {
    private static final String INPUT_DATA_PATH = "src/main/resources/inputData.csv";
    private static final String OUTPUT_DATA_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        List<FruitTransaction> fruitTransactions
                = fileReaderService.readFromFile(INPUT_DATA_PATH);
        FruitTransactionHandlerImpl fruitTransactionHandlerImpl = new FruitTransactionHandlerImpl();
        fruitTransactionHandlerImpl.handle(Storage.FRUITS, fruitTransactions);
        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.generate(Storage.FRUITS);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(OUTPUT_DATA_PATH,report);
    }
}
