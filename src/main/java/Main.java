import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.ApplyStrategyService;
import service.FileWriterService;
import service.FilerReaderService;
import service.FruitShopService;
import service.ParseService;
import service.ReportService;
import service.impl.ApplyStategyServiceImpl;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.FruitShopServiceImpl;
import service.impl.ParseServiceImpl;
import service.impl.ReportServiceImpl;
import strategy.BalanceOperationHandlerImpl;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandlerImpl;
import strategy.ReturnOperationHandlerImpl;
import strategy.SupplyOperationHandlerImpl;

public class Main {
    public static final String INPUT_FILE = "src/main/resources/input.csv";
    public static final String OUTPUT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandlerImpl());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandlerImpl());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandlerImpl());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandlerImpl());
        ParseService parseService = new ParseServiceImpl();
        FilerReaderService fileReader = new FileReaderServiceImpl();
        List<String> input = fileReader.getFileData(INPUT_FILE);
        List<FruitTransaction> fruitTransactionList = parseService.parse(input);
        ApplyStrategyService applyStrategyService =
                new ApplyStategyServiceImpl(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(applyStrategyService);
        fruitShopService.transfer(fruitTransactionList);
        ReportService reportService = new ReportServiceImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeFile(OUTPUT_FILE, reportService.createReport());
    }
}
