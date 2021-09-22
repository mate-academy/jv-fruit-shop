import java.util.HashMap;
import java.util.Map;
import model.FruitRecordDto;
import service.OperationStrategy;
import service.OperationStrategyImpl;
import service.ReportService;
import service.ReportServiceImpl;
import service.type.service.TypeHandler;
import service.type.service.TypeHandlerBalance;
import service.type.service.TypeHandlerPurchase;
import service.type.service.TypeHandlerReturn;
import service.type.service.TypeHandlerSupply;

public class Main {
    public static void main(String[] args) {
        Map<FruitRecordDto.Activities, TypeHandler> mapTypeHandler = new HashMap<>();
        mapTypeHandler.put(FruitRecordDto.Activities.BALANCE, new TypeHandlerBalance());
        mapTypeHandler.put(FruitRecordDto.Activities.PURCHASE, new TypeHandlerPurchase());
        mapTypeHandler.put(FruitRecordDto.Activities.RETURN, new TypeHandlerReturn());
        mapTypeHandler.put(FruitRecordDto.Activities.SUPPLY, new TypeHandlerSupply());
        OperationStrategy operationStrategy = new OperationStrategyImpl(mapTypeHandler);
        String pathFrom = "src/main/resources/filesFruitShop.csv";
        String pathTo = "src/main/resources/report_fruit_shop.csv";
        ReportService reportService = new ReportServiceImpl(operationStrategy);
        reportService.getReport(pathFrom, pathTo);
    }
}
