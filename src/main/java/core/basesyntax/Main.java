package core.basesyntax;

import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.FruitTransactionStrategy;
import java.util.List;

public class Main {
    private static final String PATH_TO_FILE_WITH_TRANSACTION
            = "src/main/resources/transaction.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> fruitConsider = fileReaderService.readFromFile(PATH_TO_FILE_WITH_TRANSACTION);
        FruitTransactionStrategy fruitTransactionStrategy = new FruitTransactionStrategy();
        fruitTransactionStrategy.considerTransactionWithFruit(fruitConsider);
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report, OUTPUT_FILE_PATH);
    }

}
