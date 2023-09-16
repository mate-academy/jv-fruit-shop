import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.ActivityType;
import model.FruitTransaction;
import service.FileReaderService;
import service.FileWriterService;
import service.InputTextService;
import service.ProcessService;
import service.ReportService;
import service.impl.InputTextServiceImpl;
import service.impl.ProcessServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.StoreOperationsHandler;
import strategy.impl.BalanceStoreOperationsHandler;
import strategy.impl.PurchaseStoreOperationsHandler;
import strategy.impl.ReturnStoreOperationsHandler;
import strategy.impl.SupplyStoreOperationsHandler;

public class Main {
    private static final String FROM_FILE = "src/main/resources/input.csv";
    private static final String TO_FILE = "src/main/resources/output.csv";
    private static final Map<ActivityType,
            StoreOperationsHandler> STORE_OPERATIONS_HANDLER_MAP = new HashMap<>();

    public static void main(String[] args) {
        FileReaderService fileReaderService = new ReaderServiceImpl();
        List<String> textLines = fileReaderService.readFromFileName(FROM_FILE);

        STORE_OPERATIONS_HANDLER_MAP
                .put(ActivityType.BALANCE, new BalanceStoreOperationsHandler());
        STORE_OPERATIONS_HANDLER_MAP
                .put(ActivityType.SUPPLY, new SupplyStoreOperationsHandler());
        STORE_OPERATIONS_HANDLER_MAP
                .put(ActivityType.PURCHASE, new PurchaseStoreOperationsHandler());
        STORE_OPERATIONS_HANDLER_MAP
                .put(ActivityType.RETURN, new ReturnStoreOperationsHandler());

        InputTextService inputTextService = new InputTextServiceImpl();
        List<FruitTransaction> fruitTransactions = inputTextService.processInputText(textLines);

        ProcessService processService = new ProcessServiceImpl(STORE_OPERATIONS_HANDLER_MAP);
        processService.process(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.report();

        FileWriterService fileWriterService = new WriterServiceImpl();
        fileWriterService.writeToFile(report, TO_FILE);
    }
}
