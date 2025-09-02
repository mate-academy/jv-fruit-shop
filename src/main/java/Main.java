import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataConverter;
import service.FileReader;
import service.FileWriter;
import service.OperationStrategy;
import service.ReportGenerator;
import service.ShopService;
import service.impl.DataConverterImpl;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.OperationStrategyImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import strategy.BalanceOperation;
import strategy.OperationHandler;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

public class Main {
    private static final String READ_FILE_NAME = "src/main/resources/reportToRead.csv";
    private static final String WRITE_FILE_NAME = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(READ_FILE_NAME);

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report,WRITE_FILE_NAME);
    }
}
