import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.ActivityType;
import model.FruitTransaction;
import service.FileReaderService;
import service.FileWriterService;
import service.FruitService;
import service.ProcessService;
import service.ReportService;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.FruitServiceImpl;
import service.impl.ProcessServiceImpl;
import service.impl.ReportServiceImpl;
import strategy.OperationsHandler;
import strategy.impl.BalanceOperationsHandler;
import strategy.impl.PurchaseOperationsHandler;
import strategy.impl.ReturnOperationsHandler;
import strategy.impl.SupplyOperationsHandler;

public class Main {
    private static final String FROM_FILE = "src/main/resources/input.csv";
    private static final String TO_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> textLines = fileReaderService.readFromFile(FROM_FILE);

        Map<ActivityType, OperationsHandler> storeOperationsHandler = operationsHandlerMap();

        FruitService fruitService = new FruitServiceImpl();
        List<FruitTransaction> fruitTransactions = fruitService.processFruitLines(textLines);

        ProcessService processService = new ProcessServiceImpl(storeOperationsHandler);
        processService.process(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report, TO_FILE);
    }

    private static Map<ActivityType, OperationsHandler> operationsHandlerMap() {
        Map<ActivityType, OperationsHandler> map = new HashMap<>();
        map.put(ActivityType.BALANCE, new BalanceOperationsHandler());
        map.put(ActivityType.SUPPLY, new SupplyOperationsHandler());
        map.put(ActivityType.PURCHASE, new PurchaseOperationsHandler());
        map.put(ActivityType.RETURN, new ReturnOperationsHandler());
        return map;
    }
}
