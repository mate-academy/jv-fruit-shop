import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReaderCsvImpl;
import service.FileReaderService;
import service.FileWriterCsvImpl;
import service.FileWriterService;
import service.OperationStrategy;
import service.OperationStrategyImpl;
import service.ParseImpl;
import service.ParseService;
import service.TransactionHandlerImpl;
import service.TransactionHandlerService;
import service.operation.BalanceOperationHandler;
import service.operation.OperationHandler;
import service.operation.PurchaseOperationHandler;
import service.operation.ReturnOperationHandler;
import service.operation.SupplyOperationHandler;

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
        FileWriterService fileWriter = new FileWriterCsvImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
        List<String> dataFromFile = fileReader.fileReader(inputFilePath);
        List<FruitTransaction> transactions = parse.parse(dataFromFile);
        TransactionHandlerService transactionHandler =
                new TransactionHandlerImpl(operationStrategy);
        transactionHandler.transactionHandle(transactions);
        fileWriter.fileWriter(outputFilePath);
    }
}
