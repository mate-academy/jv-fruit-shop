import db.Storage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import operations.OperationHandler;
import operations.impl.BalanceOperationHandler;
import operations.impl.PurchaseOperationHandler;
import operations.impl.ReturnOperationHandler;
import operations.impl.SupplyOperationHandler;
import service.DataProcessorService;
import service.FileReaderService;
import service.OperationStrategy;
import service.ReportGeneratorService;
import service.ReportWriterService;
import service.impl.DataProcessorServiceImpl;
import service.impl.FileReaderServiceImpl;
import service.impl.OperationStrategyImpl;
import service.impl.PathValidatorImpl;
import service.impl.ReportGeneratorServiceImpl;
import service.impl.ReportWriterServiceImpl;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) throws IOException {
        Storage storage = new Storage();

        Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap =
                new HashMap<>();

        operationOperationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        OperationStrategy operationStrategy =
                new OperationStrategyImpl(operationOperationHandlerMap);
        DataProcessorService dataProcesorService = new DataProcessorServiceImpl(operationStrategy);
        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
        ReportWriterService reportWriterService = new ReportWriterServiceImpl();

        if (new PathValidatorImpl().filePathValidator(INPUT_PATH)) {
            dataProcesorService.process(fileReaderService.readFromFile(INPUT_PATH));
        } else {
            throw new IllegalArgumentException("Invalid file path: " + INPUT_PATH);
        }

        String report = reportGeneratorService.generateReport();

        reportWriterService.writeReportToFile(report, OUTPUT_PATH);

    }
}
