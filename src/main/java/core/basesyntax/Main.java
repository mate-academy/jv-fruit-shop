package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");

        DataConverter dataConverter = new DataConverterImpl();
        FruitStock fruitStock = new FruitStock();
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceHandler(fruitStock));
        operationHandlers.put(Operation.PURCHASE, new PurchaseHandler(fruitStock));
        operationHandlers.put(Operation.RETURN, new ReturnHandler(fruitStock));
        operationHandlers.put(Operation.SUPPLY, new SupplyHandler(fruitStock));

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(fruitStock, operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGenerator(fruitStock);
        String resultingReport = reportGenerator.generateReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}
