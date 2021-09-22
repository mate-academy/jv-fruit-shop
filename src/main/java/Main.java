import java.util.HashMap;
import java.util.Map;
import model.FruitRecordDto;
import service.OperationStrategy;
import service.OperationStrategyImpl;
import service.ReportService;
import service.ReportServiceImpl;
import service.type.service.OperationHandler;
import service.type.service.BalanceHandler;
import service.type.service.PurchaseHandler;
import service.type.service.ReturnHandler;
import service.type.service.SupplyHandler;

public class Main {
    public static void main(String[] args) {
        Map<FruitRecordDto.Activities, OperationHandler> mapTypeHandler = new HashMap<>();
        mapTypeHandler.put(FruitRecordDto.Activities.BALANCE, new BalanceHandler());
        mapTypeHandler.put(FruitRecordDto.Activities.PURCHASE, new PurchaseHandler());
        mapTypeHandler.put(FruitRecordDto.Activities.RETURN, new ReturnHandler());
        mapTypeHandler.put(FruitRecordDto.Activities.SUPPLY, new SupplyHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(mapTypeHandler);
        String pathFrom = "src/main/resources/filesFruitShop.csv";
        String pathTo = "src/main/resources/report_fruit_shop.csv";
        ReportService reportService = new ReportServiceImpl(operationStrategy);
        reportService.getReport(pathFrom, pathTo);
    }
}
