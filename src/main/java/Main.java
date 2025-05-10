import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.FruitService;
import service.ParserService;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.FruitServiceImpl;
import service.impl.ParserServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.BalanceHandlerImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.PurchaseHandlerImpl;
import strategy.ReturnHandlerImpl;
import strategy.SupplyHandlerImpl;

public class Main {
    private static final String FILE_INPUT = "src/main/resources/input.cvs";
    private static final String FILE_OUTPUT = "src/main/resources/output.cvs";
    private static final ReaderService readerService = new ReaderServiceImpl();
    private static final ParserService parserService = new ParserServiceImpl();
    private static final WriterService writerService = new WriterServiceImpl();
    private static final Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();

    public static void main(String[] args) {
        List<String> fileContent = readerService.readFromFile(FILE_INPUT);
        List<FruitTransaction> fruitTransactions = parserService.parseTransactions(fileContent);
        initMapOperationHandler();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.processTransactions(fruitTransactions);
        ReportService reportService = new ReportService();
        String report = reportService.generateReport();
        writerService.writeToFile(FILE_OUTPUT, report);
    }

    private static void initMapOperationHandler() {
        operationHandlerMap.put(Operation.BALANCE, new BalanceHandlerImpl());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyHandlerImpl());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseHandlerImpl());
        operationHandlerMap.put(Operation.RETURN, new ReturnHandlerImpl());
    }
}
