package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.operation.impl.BalanceStrategyImpl;
import core.basesyntax.operation.impl.PurchaseStrategyImpl;
import core.basesyntax.operation.impl.ReturnStrategyImpl;
import core.basesyntax.operation.impl.SuppliersStrategyImpl;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ReaderService fileReader = new ReaderServiceImpl();
        List<String> inputReport = fileReader.readTheReport("src/main/resources/input.csv");

        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceStrategyImpl());
        operationHandlers.put(Operation.PURCHASE, new PurchaseStrategyImpl());
        operationHandlers.put(Operation.RETURN, new ReturnStrategyImpl());
        operationHandlers.put(Operation.SUPPLY, new SuppliersStrategyImpl());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        WriterService fileWriter = new WriterServiceImpl();
        fileWriter.writeTheReport(resultingReport, "src/main/resources/finalReport.csv");
    }
}
