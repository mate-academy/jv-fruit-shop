import db.FruitStorage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.ActivityType;
import model.FruitTransaction;
import service.FileReaderService;
import service.FileWriterService;
import service.FruitService;
import service.FruitTransactionParser;
import service.ReportService;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.FruitServiceImpl;
import service.impl.FruitTransactionParserImpl;
import service.impl.ReportServiceImpl;
import strategy.ActivityHandler;
import strategy.ActivityStrategy;
import strategy.impl.ActivityStrategyImpl;
import strategy.impl.BalanceActivityHandler;
import strategy.impl.PurchaceActivityHandler;
import strategy.impl.ReturnActivityHandler;
import strategy.impl.SupplyActivityHandler;

public class Main {
    private static final String FROM_FILE_PATH =
            "src/main/resources/fruit-shop-activities.csv";
    private static final String TO_FILE_PATH =
            "src/main/resources/fruit-shop-report.csv";

    public static void main(String[] args) {
        Map<ActivityType, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(
                ActivityType.BALANCE, new BalanceActivityHandler());
        activityHandlerMap.put(
                ActivityType.SUPPLY, new SupplyActivityHandler());
        activityHandlerMap.put(
                ActivityType.PURCHASE, new PurchaceActivityHandler());
        activityHandlerMap.put(
                ActivityType.RETURN, new ReturnActivityHandler());

        FileReaderService fileReader = new FileReaderServiceImpl();
        FruitTransactionParser dataParser = new FruitTransactionParserImpl();
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activityHandlerMap);
        FruitService fruitService = new FruitServiceImpl(activityStrategy);
        ReportService reportService = new ReportServiceImpl();
        FileWriterService fileWriter = new FileWriterServiceImpl();

        List<String> inputLines = fileReader.readFromFile(FROM_FILE_PATH);
        List<FruitTransaction> transactionList = dataParser.parse(inputLines);
        fruitService.processTransaction(transactionList);
        String report = reportService.createReport(FruitStorage.fruitStorage);
        fileWriter.writeToFile(TO_FILE_PATH, report);
        System.out.println(report);
    }
}
