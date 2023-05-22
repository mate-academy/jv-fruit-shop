import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.OperationHandler;
import service.OperationStrategy;
import service.ReaderService;
import service.ReportService;
import service.TransactionParser;
import service.WriterService;
import service.impl.OperationStrategyImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionParserImpl;
import service.impl.WriterServiceImpl;
import strategy.BalanceHandler;
import strategy.PurchaseHandler;
import strategy.ReturnHandler;
import strategy.SupplyHandler;

public class Main {
    private static final String inputFilePath = "src/main/resources/input.csv";
    private static final String outputFilePath = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();
        map.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        map.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        map.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        map.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readDataFromFile(inputFilePath);

        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactions = transactionParser
                .getTransactionList(dataFromFile);

        OperationStrategy operationStrategy = new OperationStrategyImpl(map);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler handler = operationStrategy.get(fruitTransaction.getOperation());
            handler.handle(fruitTransaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeDataToFile(report, outputFilePath);
    }
}
