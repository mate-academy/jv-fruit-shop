package core.basesyntax;

import core.basesyntax.db.StorageImpl;
import core.basesyntax.service.DataValidatorService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ParserOperationService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataValidatorServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ParserOperationServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH
            = "src/main/java/core/basesyntax/resuorse/statisticDataFile.csv";
    private static final String STATISTIC_FILE_PATH
            = "src/main/java/core/basesyntax/resuorse/reportDataFile.csv";

    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        FruitShopService fruitTransactionService = new FruitShopServiceImpl(operationStrategy);
        List<String> dataFromFile = reader.readFromFile(INPUT_FILE_PATH);
        DataValidatorService isDataChecker = new DataValidatorServiceImpl();
        if (isDataChecker.isDataValid(dataFromFile)) {
            ParserOperationService transactionParser = new ParserOperationServiceImpl();
            fruitTransactionService.processOfOperations(transactionParser.parser(dataFromFile));
        }
        ReportService greatReport = new ReportServiceImpl();
        String stringReport = greatReport.generateReport(StorageImpl.fruits);
        WriterService writer = new WriterServiceImpl();
        writer.writeToFile(STATISTIC_FILE_PATH, stringReport);
    }
}
