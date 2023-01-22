import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.FileWriterService;
import service.FruitTransactionProcessor;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.FruitTransactionParserImpl;
import service.impl.FruitTransactionProcessorImpl;
import service.impl.ReportServiceImpl;
import strategy.OperationHandler;
import strategy.impl.BalanceOperationHandler;
import strategy.impl.PurchaseOperationHandler;
import strategy.impl.ReturnsOperationHandler;
import strategy.impl.SupplyOperationHandler;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/daily_summary.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnsOperationHandler());
        FruitTransactionProcessor fruitTransactionProcessor =
                new FruitTransactionProcessorImpl(operationHandlerMap);

        List<String> data = new FileReaderServiceImpl().read(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactionData = new FruitTransactionParserImpl()
                .parseList(data);
        fruitTransactionData.forEach(f -> fruitTransactionProcessor.get(f.getOperation())
                .handle(f));
        String report = new ReportServiceImpl().getReport(Storage.fruits);
        System.out.println(report);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(report, REPORT_FILE_PATH);
    }
}
