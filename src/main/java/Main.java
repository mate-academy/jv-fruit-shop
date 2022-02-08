
import dao.ReaderService;
import dao.ReaderServiceImp;
import dao.WriterService;
import dao.WriterServiceImp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.ReportService;
import service.ReportServiceImp;
import service.StrategyHandler;
import service.StrategyHandlerImp;
import service.activities.Activities;
import service.activities.BalanceActivity;
import service.activities.PurchaseActivity;
import service.activities.ReturnActivity;
import service.activities.SupplyActivity;

public class Main {

    public static void main(String[] args) {
        Map<String, Activities> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put("b", new BalanceActivity());
        activitiesHandlerMap.put("p", new PurchaseActivity());
        activitiesHandlerMap.put("r", new ReturnActivity());
        activitiesHandlerMap.put("s", new SupplyActivity());

        StrategyHandler strategyHandler = new StrategyHandlerImp(activitiesHandlerMap);
        ReaderService readerService = new ReaderServiceImp();
        WriterService writerService = new WriterServiceImp();
        ReportService reportService = new ReportServiceImp(strategyHandler);
        String filePath = "src/main/resources/activities_day_one.csv";

        List<String> strings = readerService.readFromFile(filePath);
        List<String> reportList = reportService.makeBalanceReport(strings);
        writerService.writeToFile(reportList);
    }
}
