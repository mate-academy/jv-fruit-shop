package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.readFile("reportToRead.csv");

        Parser parser = new ParserImpl();
        List<FruitTransaction> transactions = parser.parse(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        OperationHandlerProvider operationHandlerProvider =
                new OperationHandlerProviderImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationHandlerProvider);
        Map<String, Integer> result = shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        List<String> resultingReport = reportGenerator.generate(result);

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeFile(resultingReport, "finalReport.csv");
    }
}
