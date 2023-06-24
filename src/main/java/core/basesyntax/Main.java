package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.CalculateStrategy;
import core.basesyntax.strategy.impl.CalculateStrategyImpl;
import java.io.File;
import java.util.List;

public class Main {
    public static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    public static final String TO_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        CalculateStrategy calculateStrategy = new CalculateStrategyImpl();
        ReaderService readerService = new ReaderServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        FruitService fruitService = new FruitServiceImpl(calculateStrategy);
        DataParserService dataParserService = new DataParserServiceImpl();
        ReportMakerService reportMakerService = new ReportMakerServiceImpl();
        File file = new File(INPUT_FILE_NAME);
        List<String> dataFromFile = readerService.readDataFromFile(file);
        List<FruitTransaction> parsedDataFromFile = dataParserService
                .parseDataToFruitTransaction(dataFromFile);
        fruitService
                .calculateTotalQuantity(parsedDataFromFile);
        String report = reportMakerService.generateReport(FruitStorage.fruitStorage);
        writerService.writeDataToFile(report, TO_FILE_NAME);
    }
}
