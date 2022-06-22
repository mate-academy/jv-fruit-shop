import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruit;
import model.Operation;
import strategy.OperationHandler;
import service.ParseDataService;
import service.ProcessDataService;
import service.ReaderService;
import service.ReportGeneratingService;
import service.ReportWriterService;
import service.impl.ParseDataServiceImpl;
import service.impl.ProcessDataServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportGeneratingServiceImpl;
import service.impl.ReportWriterServiceImpl;
import strategy.BalanceOperationService;
import strategy.OperationStrategy;
import strategy.PurchaseOperationService;
import strategy.ReturnOperationService;
import strategy.SupplyOperationService;

public class Main {
    private static final String ACTIVITIES_IN_STORE = "src/main/my-resources/activities.csv";
    private static final String REPORT = "src/main/my-resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandler = new HashMap<>();
        operationHandler.put(Operation.BALANCE, new BalanceOperationService());
        operationHandler.put(Operation.SUPPLY, new SupplyOperationService());
        operationHandler.put(Operation.PURCHASE, new PurchaseOperationService());
        operationHandler.put(Operation.RETURN, new ReturnOperationService());
        OperationStrategy.setOperationHandler(operationHandler);
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFile(ACTIVITIES_IN_STORE);
        ParseDataService parseDataService = new ParseDataServiceImpl();
        List<Fruit> parsedValues = parseDataService.parseData(dataFromFile);
        ProcessDataService processDataService = new ProcessDataServiceImpl();
        List<Fruit> db = processDataService.processData(parsedValues);
        ReportGeneratingService reportGeneratingService = new ReportGeneratingServiceImpl();
        List<String> report = reportGeneratingService.createReport(db);
        ReportWriterService reportWriterService = new ReportWriterServiceImpl();
        reportWriterService.writeReport(report, REPORT);
    }
}
