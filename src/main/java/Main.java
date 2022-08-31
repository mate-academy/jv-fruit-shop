import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ParserTransactionsService;
import service.ProcessDataService;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.ParserTransactionsServiceImpl;
import service.impl.ProcessDataServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;
import storage.Storage;
import strategy.handler.BalanceOperationHandlerImpl;
import strategy.handler.OperationHandler;
import strategy.handler.PurchaseOperationHandlerImpl;
import strategy.handler.ReturnOperationHandlerImpl;
import strategy.handler.SupplyOperationHandlerImpl;

public class Main {
    public static final String DAILY_OPERATIONS_FILE
            = "src/main/java/resources/dailyoperations.csv";
    public static final String DAILY_REPORT_FILE
            = "src/main/java/resources/dailyreport.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        Path pathInput = Paths.get(DAILY_OPERATIONS_FILE);
        List<String> readData = readerService.read(pathInput);
        ParserTransactionsService parserTransactionsService = new ParserTransactionsServiceImpl();
        List<FruitTransaction> fruitTransactions = parserTransactionsService.parse(readData);
        ProcessDataService processDataService = new ProcessDataServiceImpl(fillMap());
        processDataService.processData(fruitTransactions);
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        Path pathOutput = Paths.get(DAILY_REPORT_FILE);
        writerService.write(pathOutput, reportService.report());
    }

    private static Map<FruitTransaction.Operation, OperationHandler> fillMap() {
        Map<FruitTransaction.Operation, OperationHandler> operations = new HashMap<>();
        operations.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandlerImpl());
        operations.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandlerImpl());
        operations.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandlerImpl());
        operations.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandlerImpl());
        return operations;
    }
}
