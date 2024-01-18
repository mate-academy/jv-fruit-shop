import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ParserService;
import service.ReaderService;
import service.ReportService;
import service.StrategyService;
import service.TransactionService;
import service.WriterService;
import service.impl.ParserServiceImpl;
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
    public static final String FILE_INPUT_PATH = "src/main/resources/input.csv";
    public static final String FILE_OUTPUT_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationMap =
                Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperation(),
                        FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
                        FruitTransaction.Operation.SUPPLY, new SupplyOperation(),
                        FruitTransaction.Operation.RETURN, new ReturnOperation());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromCsvFile = readerService.readFromFile(FILE_INPUT_PATH);

        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parseOperations(dataFromCsvFile);

        StrategyService strategyService = new StrategyServiceImpl(operationMap);

        TransactionService transactionService = new TransactionServiceImpl(strategyService);
        transactionService.processTransactions(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeReport(FILE_OUTPUT_PATH, report);

    }
}

