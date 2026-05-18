package core.basesyntax;

import core.basesyntax.serviceimpl.ReportGeneratorImpl;
import core.basesyntax.serviceimpl.ShopServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        Storage storage = new Storage();
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");
        DataConverter dataConverter = new DataConverterImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(storage));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(storage));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(storage));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(storage));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String resultingReport = reportGenerator.getReport();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}
