import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataConverter;
import service.ReaderService;
import service.ReportGenerator;
import service.ShopService;
import service.WriterService;
import service.imp.DataConverterImpl;
import service.imp.ReaderServiceImpl;
import service.imp.ReportGeneratorImpl;
import service.imp.ShopServiceImpl;
import service.imp.WriterServiceImpl;
import service.operation.BalanceOperation;
import service.operation.OperationHandler;
import service.operation.PurchaseOperation;
import service.operation.ReturnOperation;
import service.operation.SupplyOperation;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String FROM_FILE = "src/main/resources/reportToRead.csv";
    private static final String TO_FILE = "src/main/resources/finalReport.csv";
    private static List<FruitTransaction> transactions;

    public static void main(String[] arg) {
        ReaderService fileReader = new ReaderServiceImpl();
        List<String> inputReport = fileReader.read(FROM_FILE);

        DataConverter dataConverter = new DataConverterImpl();
        transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.write(resultingReport, TO_FILE);
    }
}
