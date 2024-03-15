import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ParseService;
import service.ReaderService;
import service.ReportService;
import service.StrategyService;
import service.TransactionService;
import service.WriterService;
import service.impl.ParseServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.StrategyServiceImpl;
import service.impl.TransactionServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.BalanceOperation;
import strategy.OperationHandler;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

public class Main {
    private static final String PATH_TO_FILE = "src/main/java/resources/fileToRead.csv";
    private static final String PATH_TO_REPORT_FILE = "src/main/java/resources/reportFile.csv";
    private static final ReaderService readerService = new ReaderServiceImpl();
    private static final ParseService parseService = new ParseServiceImpl();
    private static final ReportService reportService = new ReportServiceImpl();
    private static final WriterService writerService = new WriterServiceImpl();

    private static StrategyService strategyService;
    private static TransactionService transactionService;

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationMap =
                Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperation(),
                        FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
                        FruitTransaction.Operation.SUPPLY, new SupplyOperation(),
                        FruitTransaction.Operation.RETURN, new ReturnOperation());
        List<String> dataFromFile = readerService.readFromFile(PATH_TO_FILE);
        List<FruitTransaction> values = parseService.parseOperation(dataFromFile);
        strategyService = new StrategyServiceImpl(operationMap);
        transactionService = new TransactionServiceImpl(strategyService);
        transactionService.transactionsProcess(values);
        String report = reportService.createReport();
        writerService.writeToFile(PATH_TO_REPORT_FILE,report);

    }
}
