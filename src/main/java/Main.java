import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.CreateReportService;
import service.FileReaderService;
import service.FileWriterService;
import service.ParseService;
import service.TransactionHandlerService;
import service.impl.CreateReportImpl;
import service.impl.FileReaderCsvImpl;
import service.impl.FileWriterCsvImpl;
import service.impl.ParseImpl;
import service.impl.TransactionHandlerImpl;
import service.operation.BalanceOperationHandler;
import service.operation.OperationHandler;
import service.operation.PurchaseOperationHandler;
import service.operation.ReturnOperationHandler;
import service.operation.SupplyOperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String inputFilePath = "src/main/resources/inputFile.csv";
    private static final String outputFilePath = "src/main/resources/exportFile.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.OperationType, OperationHandler> handlerMap = Map.of(
                FruitTransaction.OperationType.BALANCE, new BalanceOperationHandler(),
                FruitTransaction.OperationType.SUPPLY, new SupplyOperationHandler(),
                FruitTransaction.OperationType.PURCHASE, new PurchaseOperationHandler(),
                FruitTransaction.OperationType.RETURN, new ReturnOperationHandler());

        FileReaderService fileReader = new FileReaderCsvImpl();
        ParseService parse = new ParseImpl();
        CreateReportService createReport = new CreateReportImpl();
        FileWriterService fileWriter = new FileWriterCsvImpl(createReport);
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
        List<String> dataFromFile = fileReader.readFile(inputFilePath);
        List<FruitTransaction> transactions = parse.parse(dataFromFile);
        TransactionHandlerService transactionHandler =
                new TransactionHandlerImpl(operationStrategy);
        transactionHandler.handleTransactions(transactions);
        fileWriter.writeFile(outputFilePath);
    }
}
