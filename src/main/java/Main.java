import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ReaderService;
import service.ReportService;
import service.TransactionParser;
import service.WriterService;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionParserImpl;
import service.impl.WriterServiceImpl;
import service.operations.BalanceOperationHandler;
import service.operations.OperationHandler;
import service.operations.OperationStrategy;
import service.operations.OperationStrategyImpl;
import service.operations.PurchaseOperationHandler;
import service.operations.ReturnOperationHandler;
import service.operations.SupplyOperationHandler;

public class Main {
    public static final String FILE_PATH_READ_FROM = "src/Main/resources/FruitShop.csv";
    public static final String FILE_PATH_WRIRTE_TO = "src/Main/resources/FruitShopReport.csv";

    public static void main(String[] args) {
        ReaderService fileReader = new ReaderServiceImpl();
        List<String> dataFromFile = fileReader.readFromFile(FILE_PATH_READ_FROM);
        TransactionParser transactionParser = new TransactionParserImpl();

        Map<FruitTransaction.Operation, OperationHandler> strategies = new HashMap<>();
        strategies.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        strategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        strategies.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        strategies.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        List<FruitTransaction> fruitTransactionsList = transactionParser.parse(dataFromFile);
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategies);

        for (FruitTransaction fruitTransaction : fruitTransactionsList) {
            OperationHandler handler = operationStrategy
                    .get(fruitTransaction.getOperation());
            handler.operate(fruitTransaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, FILE_PATH_WRIRTE_TO);
    }
}
