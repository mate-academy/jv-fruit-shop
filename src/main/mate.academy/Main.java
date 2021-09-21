import service.FileReader;
import service.FileReaderImpl;
import service.FileWriter;
import service.FileWriterImpl;
import model.FruitRecord;
import model.Operation;
import service.FruitShopService;
import service.FruitShopServiceImpl;
import service.OperationStrategy;
import service.OperationStrategyImpl;
import service.ReportService;
import service.ReportServiceImpl;
import service.operation.BalanceHandlerImpl;
import service.operation.FruitParser;
import service.operation.Handler;
import service.operation.PurchaseHandlerImpl;
import service.operation.ReturnHandlerImpl;
import service.operation.SupplyHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT = "src/main/resources/input.csv";
    public static final String OUTPUT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        Handler balanceHandler = new BalanceHandlerImpl();
        Handler purchaseHandler = new PurchaseHandlerImpl();
        Handler supplyHandler = new SupplyHandlerImpl();
        Handler returnHandler = new ReturnHandlerImpl();
        Map<String, Handler> handlerMap = new HashMap<>();
        handlerMap.put(Operation.BALANCE.getOperation(), balanceHandler);
        handlerMap.put(Operation.SUPPLY.getOperation(), supplyHandler);
        handlerMap.put(Operation.PURCHASE.getOperation(), purchaseHandler);
        handlerMap.put(Operation.RETURN.getOperation(), returnHandler);
        FruitParser fruitParser = new FruitParser();
        List<String> input = fileReader.getFileData(INPUT);
        List<FruitRecord> fruitRecordList = fruitParser.createDto(input);
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        fruitShopService.transfer(fruitRecordList);
        ReportService reportService = new ReportServiceImpl();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeFile(OUTPUT, reportService.createReport());
    }
}