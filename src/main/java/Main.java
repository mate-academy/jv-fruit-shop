import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReaderService;
import service.FileWriterService;
import service.FruitShopService;
import service.ReportService;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.FruitShopServiceImpl;
import service.impl.ReportServiceImpl;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.PurchaseOperationHandler;
import strategy.ReturnOperationHandler;
import strategy.SupplyOperationHandler;

public class Main {
    public static final String INPUT_FILE = "src/main/resources/input.csv";
    public static final String OUT_PUT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        File result = new File(OUT_PUT_FILE);
        result.delete();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap
                .put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap
                .put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap
                .put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap
                .put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> listFromInputFile = fileReaderService.readFromFile(INPUT_FILE);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        fruitShopService.process(listFromInputFile);
        ReportService reportService = new ReportServiceImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(OUT_PUT_FILE, reportService.createReport());
    }
}
