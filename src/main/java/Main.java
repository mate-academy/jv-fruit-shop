import core.basesyntax.impl.FileReaderServiceImpl;
import core.basesyntax.impl.FileWriterServiceImpl;
import core.basesyntax.impl.FruitShopServiceImpl;
import core.basesyntax.impl.OperationHandlerStrategyImpl;
import core.basesyntax.impl.ParseDataServiceImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.FileReaderService;
import core.basesyntax.servise.FileWriterService;
import core.basesyntax.servise.FruitShopService;
import core.basesyntax.servise.OperationHandlerStrategy;
import core.basesyntax.servise.ParseDataService;
import core.basesyntax.servise.ReportService;
import java.util.List;

public class Main {
    private static final String FROM_FILE = "src/main/resources/database.csv";
    private static final String TO_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> dataFromFile = fileReaderService.read(FROM_FILE);
        ParseDataService parseDataService = new ParseDataServiceImpl();
        List<FruitTransaction> fruitTransactionList = parseDataService.parse(dataFromFile);
        OperationHandlerStrategy operationHandlerStrategy = new OperationHandlerStrategyImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationHandlerStrategy);
        fruitShopService.apply(fruitTransactionList);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeFile(TO_FILE, report);
    }
}
