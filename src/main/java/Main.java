import db.FruitStorage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.ActivityType;
import model.FruitTransaction;
import service.ActivityChecker;
import service.CsvFileReaderService;
import service.CsvFileWriterService;
import service.DataParser;
import service.FruitService;
import service.ReportService;
import service.impl.ActivityCheckerImpl;
import service.impl.CsvFileReaderServiceImpl;
import service.impl.CsvFileWriterServiceImpl;
import service.impl.DataParserImpl;
import service.impl.FruitServiceImpl;
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
        Map<String, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(
                ActivityType.BALANCE.getActivity(), new BalanceActivityHandler());
        activityHandlerMap.put(
                ActivityType.SUPPLY.getActivity(), new SupplyActivityHandler());
        activityHandlerMap.put(
                ActivityType.PURCHASE.getActivity(), new PurchaceActivityHandler());
        activityHandlerMap.put(
                ActivityType.RETURN.getActivity(), new ReturnActivityHandler());

        CsvFileReaderService fileReader = new CsvFileReaderServiceImpl();
        ActivityChecker activityChecker = new ActivityCheckerImpl();
        DataParser dataParser = new DataParserImpl(activityChecker);
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activityHandlerMap);
        FruitService fruitService = new FruitServiceImpl(activityStrategy);
        ReportService reportService = new ReportServiceImpl();
        CsvFileWriterService fileWriter = new CsvFileWriterServiceImpl();

        List<String> inputLines = fileReader.readFromFile(FROM_FILE_PATH);
        List<FruitTransaction> transactionList = dataParser.splitToCategories(inputLines);
        fruitService.putInStorage(transactionList);
        String report = reportService.createReport(FruitStorage.fruitStorage);
        fileWriter.writeToFile(TO_FILE_PATH, report);
        System.out.println(report);
    }
}
