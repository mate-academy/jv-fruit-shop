import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitActivitiesModel;
import service.OperationStrategy;
import service.ReadService;
import service.ReportService;
import service.TransactionParser;
import service.WriteService;
import service.impl.OperationStrategyImpl;
import service.impl.ReadServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionParserImpl;
import service.impl.WriteServiceImpl;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.ReturnOperationHandler;
import strategy.SupplyOperationHandler;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/database.csv";
    private static final String REPORT_FILE_PATH = "src/main/report.csv";

    public static void main(String[] args) {
        Map<FruitActivitiesModel.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitActivitiesModel.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitActivitiesModel.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitActivitiesModel.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitActivitiesModel.Operation.RETURN,
                new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReadService readService = new ReadServiceImpl();
        TransactionParser parser = new TransactionParserImpl();
        List<String> dataFromFile = readService.read(INPUT_FILE_PATH);
        List<FruitActivitiesModel> fruitTransactions = parser.parse(dataFromFile);

        for (FruitActivitiesModel fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation());
            operationHandler.operate(fruitTransaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        WriteService writerService = new WriteServiceImpl();
        writerService.writeToFile(REPORT_FILE_PATH, report);
    }
}
