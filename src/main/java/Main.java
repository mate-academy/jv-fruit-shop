import fruitscontent.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.FruitShopService;
import service.ParserOperationService;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.FruitShopServiceImpl;
import service.impl.ParserOperationServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.impl.BalanceOperationHandlerImpl;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseOperationHandlerImpl;
import strategy.impl.ReturnOperationHandlerImpl;
import strategy.impl.SupplyOperationHandlerImpl;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandlerImpl());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> inputData = readerService.readFromFile(INPUT_FILE_PATH);

        ParserOperationService transactionService = new ParserOperationServiceImpl();
        List<FruitTransaction> fruitTransactions =
                transactionService.parseContentForOperations(inputData);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService transactionHandler = new FruitShopServiceImpl(operationStrategy);
        transactionHandler.processOfOperations(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.report();
        System.out.println(report);

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
