package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.DataConverter;
import service.DataConverterImpl;
import service.FileReader;
import service.FileReaderImpl;
import service.FileWriter;
import service.FileWriterImpl;
import service.ReportGenerator;
import service.ReportGeneratorImpl;
import service.ShopService;
import service.ShopServiceImpl;
import strategy.BalanceOperation;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

public class Main {
    private static final String FILE_PATH_FROM = "src/main/java/resources/fruits.csv";
    private static final String FILE_PATH_TO = "src/main/java/resources/finalReport.csv";

    public static void main(String[] arg) {

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(FILE_PATH_FROM);

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
        fileWriter.write(resultingReport, FILE_PATH_TO);

        System.out.println("Report generated successfully!");
    }
}

