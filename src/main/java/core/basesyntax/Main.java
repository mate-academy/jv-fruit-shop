import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "reportToRead.csv";
    private static final String OUTPUT_FILE_PATH = "finalReport.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(INPUT_FILE_PATH);

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<String, Integer> fruitStorage = new HashMap<>();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperation(fruitStorage),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(fruitStorage),
                FruitTransaction.Operation.RETURN, new ReturnOperation(fruitStorage),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation(fruitStorage)
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(fruitStorage);
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, OUTPUT_FILE_PATH);
    }
}
