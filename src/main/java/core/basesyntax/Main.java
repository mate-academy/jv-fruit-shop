package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.implementation.FileReaderServiceImpl;
import core.basesyntax.service.implementation.FileWriterServiceImpl;
import core.basesyntax.service.implementation.FruitShopServiceImpl;
import core.basesyntax.service.implementation.ParserServiceImpl;
import core.basesyntax.service.implementation.ReportServiceImpl;
import java.util.List;

public class Main {
    private static final String SOURCE_FILE_PATH = "src/main/resources/FruitStorageOperation.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/Report.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> stringFromFile = fileReaderService.readFromFile(SOURCE_FILE_PATH);

        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactionList
                = parserService.parseFruitTransaction(stringFromFile);

        FruitShopService fruitShopService = new FruitShopServiceImpl();
        fruitShopService.processFruitTransaction(fruitTransactionList);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.report(Storage.fruits);

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(REPORT_FILE_PATH, report);
    }
}
