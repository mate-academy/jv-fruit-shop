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
    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> textLines = fileReaderService.readFromFileName("src/main/resources/input.csv");

        Map<ActivityType, OperationsHandler> storeOperationsHandler = new HashMap<>();
        storeOperationsHandler
                .put(ActivityType.BALANCE, new BalanceOperationsHandler());
        storeOperationsHandler
                .put(ActivityType.SUPPLY, new SupplyOperationsHandler());
        storeOperationsHandler
                .put(ActivityType.PURCHASE, new PurchaseOperationsHandler());
        storeOperationsHandler
                .put(ActivityType.RETURN, new ReturnOperationsHandler());

        FruitService fruitService = new FruitServiceImpl();
        List<FruitTransaction> fruitTransactions = fruitService.processFruitLines(textLines);

        ProcessService processService = new ProcessServiceImpl(storeOperationsHandler);
        processService.process(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report, "src/main/resources/output.csv");
    }
}
