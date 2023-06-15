import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ParseService;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.ParseServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.operation.BalanceOperationHandler;
import strategy.operation.OperationStrategyImpl;
import strategy.operation.PurchaseOperationHandler;
import strategy.operation.ReturnOperationHandler;
import strategy.operation.SupplyOperationHandler;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> records = readerService.readFromFile(INPUT_FILE_NAME);

        ParseService parseService = new ParseServiceImpl();
        List<FruitTransaction> fruitTransactions = parseService.parseFruitTransaction(records);

        Map<FruitTransaction.Operation, OperationHandler> operationMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler()
        );

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation());
            operationHandler.handle(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.write(report, OUTPUT_FILE_NAME);

        System.out.println(readerService.readFromFile(OUTPUT_FILE_NAME));
    }
}
