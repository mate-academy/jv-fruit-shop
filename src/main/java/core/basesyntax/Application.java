package core.basesyntax;

import core.basesyntax.service.DataHandler;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportCreateService;
import core.basesyntax.service.impl.FileReaderServiceCsv;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitDataHandler;
import core.basesyntax.service.impl.FruitReportCreateService;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class Application {
    private static final String FILE_NAME_FROM = "src/main/resources/database.csv";
    private static final String FILE_NAME_TO = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceCsv();
        DataHandler dataHandler = new FruitDataHandler(new OperationStrategyImpl());
        ReportCreateService reportCreateService = new FruitReportCreateService();
        FruitShopService fruitService = new FruitShopServiceImpl(dataHandler, reportCreateService);
        FileWriterService fileWriterService = new FileWriterServiceImpl();

        List<String> dataFromFile = fileReaderService.readFromFile(FILE_NAME_FROM);
        String report = fruitService.makeDailyReport(dataFromFile);
        fileWriterService.writeToFile(report, FILE_NAME_TO);
    }
}
