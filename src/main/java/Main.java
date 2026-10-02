import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataConverter;
import service.DataConverterImpl;
import service.FileReaderImpl;
import service.FileWriter;
import service.FileWriterImpl;
import service.ReportGenerator;
import service.ReportGeneratorImpl;
import service.ShopService;
import service.ShopServiceImpl;
import service.operation.BalanceOperation;
import service.operation.OperationHandler;
import service.operation.PurchaseOperation;
import service.operation.ReturnOperation;
import service.operation.SupplyOperation;
import service.strategy.OperationStrategy;
import service.strategy.OperationStrategyImpl;

public class Main {
    public static void main(String[] args) {
        service.FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");
        DataConverter dataConverter = new DataConverterImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        shopService.process(transactions);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}
