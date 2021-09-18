import dao.FileAccessDaoCsv;
import dao.FileAccessDaoCsvImpl;
import java.util.HashMap;
import java.util.Map;
import service.ActivityStrategy;
import service.ActivityStrategyImpl;
import service.InputValidator;
import service.InputValidatorImpl;
import service.ReportService;
import service.ReportServiceImpl;
import service.activityhandler.ActivityHandler;
import service.activityhandler.BalanceActivityHandler;
import service.activityhandler.PurchaseActivityHandler;
import service.activityhandler.ReturnActivityHandler;
import service.activityhandler.SupplyActivityHandler;

public class Main {
    private static final String IN_FILE_PATH = "src/main/resources/shopInput_OK.csv";
    private static final String OUT_FILE_PATH = "src/main/resources/shopReport.csv";

    public static void main(String[] args) {
        Map<String, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put("b", new BalanceActivityHandler());
        activityHandlerMap.put("p", new PurchaseActivityHandler());
        activityHandlerMap.put("r", new ReturnActivityHandler());
        activityHandlerMap.put("s", new SupplyActivityHandler());

        ActivityStrategy strategy = new ActivityStrategyImpl(activityHandlerMap);
        FileAccessDaoCsv fileDao = new FileAccessDaoCsvImpl();
        InputValidator validator = new InputValidatorImpl();

        ReportService reportService = new ReportServiceImpl(fileDao, validator, strategy);
        reportService.generateReport(IN_FILE_PATH, OUT_FILE_PATH);

        System.out.println("Report has been generated at " + OUT_FILE_PATH);
    }
}

