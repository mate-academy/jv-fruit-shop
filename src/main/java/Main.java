import model.fruitActivitiesModel;
import service.OperationStrategy;
import service.ReadService;
import service.ReportService;
import service.TransactionParser;
import service.WriteService;
import serviceImpl.OperationStrategyImpl;
import serviceImpl.ReadServiceImpl;
import serviceImpl.ReportServiceImpl;
import serviceImpl.TransactionParserImpl;
import serviceImpl.WriteServiceImpl;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.ReturnOperationHandler;
import strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/database.csv";
    private static final String REPORT_FILE_PATH = "src/main/report.csv";

    public static void main(String[] args) {
        Map<fruitActivitiesModel.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(fruitActivitiesModel.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(fruitActivitiesModel.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(fruitActivitiesModel.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(fruitActivitiesModel.Operation.RETURN,
                new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReadService readService = new ReadServiceImpl();
        TransactionParser parser = new TransactionParserImpl();
        List<String> dataFromFile = readService.read(INPUT_FILE_PATH);
        List<fruitActivitiesModel> fruitTransactions = parser.parse(dataFromFile);

        for (fruitActivitiesModel fruitTransaction : fruitTransactions) {
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