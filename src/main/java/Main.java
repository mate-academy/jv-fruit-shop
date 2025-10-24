import interfaces.DataConverter;
import interfaces.FileReader;
import interfaces.FileWriter;
import interfaces.OperationHandler;
import interfaces.OperationStrategy;
import interfaces.ReportGenerator;
import interfaces.ShopService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import operations.BalanceOperation;
import operations.PurchaseOperation;
import operations.ReturnOperation;
import operations.SupplyOperation;
import service.impl.DataConverterImpl;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.FruitTransaction;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String FILE_PATH = "src/main/resources/reportToRead.csv";
    private static final String FINAL_REPORT_PATH = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        DataConverter converter = new DataConverterImpl();
        final FileWriter writer = new FileWriterImpl();

        final List<String> inputReport = reader.read(FILE_PATH);

        final List<FruitTransaction> transactions = converter.convertToTransaction(inputReport);

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

        writer.write(resultingReport, FINAL_REPORT_PATH);
    }
}
