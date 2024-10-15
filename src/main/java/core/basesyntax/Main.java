package core.basesyntax;

import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.converter.FileReaderImpl;
import core.basesyntax.converter.FileWriter;
import core.basesyntax.converter.FileWriterImpl;
import core.basesyntax.operation.BalanceHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.operation.PurchaseHandler;
import core.basesyntax.operation.ReturnHandler;
import core.basesyntax.operation.ShopService;
import core.basesyntax.operation.ShopServiceImpl;
import core.basesyntax.operation.SupplyHandler;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.transaction.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReaderImpl fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.txt");

        DataConverterImpl dataConverterimpl = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverterimpl
                .converterToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.generateReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalToRead.csv");
    }
}
