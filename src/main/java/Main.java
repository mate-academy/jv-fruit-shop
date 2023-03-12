import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReaderService;
import service.FileWriterService;
import service.ReportService;
import service.TransactionParser;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionParserImpl;
import service.strategy.BalanceOperationHandler;
import service.strategy.OperationHandler;
import service.strategy.OperationStrategy;
import service.strategy.OperationStrategyImpl;
import service.strategy.PurchaseOperationHandler;
import service.strategy.ReturnOperationHandler;
import service.strategy.SupplyOperationHandler;

public class Main {
    public static void main(String[] args) {
        String fileName = "src\\resources\\file.csv";
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> fruitList = fileReaderService.readFromFile(fileName);

        TransactionParser transactionParser = new TransactionParserImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());

        List<FruitTransaction> fruitTransactionList = transactionParser.parseAll(fruitList);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler operationHandler =
                    operationStrategy.get(fruitTransaction.getOperation());
            operationHandler.operate(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.makeReport();

        String filePath = "src\\resources\\result.csv";
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report, filePath);
    }
}
