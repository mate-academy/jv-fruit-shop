import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.FruitTransactionMapper;
import service.ReaderService;
import service.ReportService;
import service.StrategyService;
import service.TransactionProcessor;
import service.WriterService;
import service.impl.FruitMapperImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.StrategyServiceImpl;
import service.impl.TransactionProcessorImpl;
import service.impl.WriterServiceImpl;
import strategy.BalanceOperation;
import strategy.OperationHandler;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

public class Main {
    private static final String PATH_TO_FILE = "src/main/resources/fileToRead.csv";
    private static final String PATH_TO_REPORT_FILE = "src/main/resources/reportFile.csv";
    private static final ReaderService readerService = new ReaderServiceImpl();
    private static final FruitTransactionMapper parseService = new FruitMapperImpl();
    private static final ReportService reportService = new ReportServiceImpl();
    private static final WriterService writerService = new WriterServiceImpl();

    private static StrategyService strategyService;
    private static TransactionProcessor transactionService;

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationMap =
                Map.of(Operation.BALANCE, new BalanceOperation(),
                        Operation.PURCHASE, new PurchaseOperation(),
                        Operation.SUPPLY, new SupplyOperation(),
                        Operation.RETURN, new ReturnOperation());
        List<String> dataFromFile = readerService.readFromFile(PATH_TO_FILE);
        List<FruitTransaction> values = parseService.map(dataFromFile);

        strategyService = new StrategyServiceImpl(operationMap);
        transactionService = new TransactionProcessorImpl(strategyService);

        transactionService.process(values);
        String report = reportService.createReport();

        writerService.writeToFile(PATH_TO_REPORT_FILE,report);
    }
}
