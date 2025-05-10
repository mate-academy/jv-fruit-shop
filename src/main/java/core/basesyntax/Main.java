package core.basesyntax;

import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.converter.FileReaderImpl;
import core.basesyntax.converter.FileWriter;
import core.basesyntax.converter.FileWriterImpl;
import core.basesyntax.operation.BalanceHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseHandler;
import core.basesyntax.operation.ReturnHandler;
import core.basesyntax.operation.SupplyHandler;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.transaction.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReaderImpl fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader
                .read("C:/Users/DELL/IdeaProjects"
                        + "/jv-fruit-shop/src/main/java/core/basesyntax/reportToRead.csv");

        DataConverterImpl dataConverterimpl = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverterimpl
                .converterToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();

        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(shopService));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseHandler(shopService));
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler(shopService));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(shopService));

        shopService.process(transactions);

        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl();
        reportGenerator.setShopService(shopService);
        String resultingReport = reportGenerator.generateReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport,
                "C:/Users/DELL/IdeaProjects"
                        + "/jv-fruit-shop/src/main/java/core/basesyntax/finalToRead.csv");
    }
}
