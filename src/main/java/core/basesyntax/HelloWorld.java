package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.FruitTransactionStrategy;
import java.util.List;

public class HelloWorld {
    private static final String PATH_TO_FILE_WITH_TRANSACTION
            = "src/main/resources/transaction.csv";
    private static final String PATH_TO_FILE_FOR_REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> fruitConsider = fileReaderService.readFromFile(PATH_TO_FILE_WITH_TRANSACTION);
        FruitTransactionStrategy fruitTransactionStrategy = new FruitTransactionStrategy();
        fruitTransactionStrategy.considerTransactionWithFruit(fruitConsider);
        ReportCreatorImpl reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(FruitStorage.storageFruits);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report, PATH_TO_FILE_FOR_REPORT);
    }

}
