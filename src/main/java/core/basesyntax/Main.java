package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.serviceimpl.DataConverterImpl;
import core.basesyntax.serviceimpl.FileReaderImpl;
import core.basesyntax.serviceimpl.FileWriterServiceImpl;
import core.basesyntax.serviceimpl.ReportGeneratorImpl;
import core.basesyntax.serviceimpl.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperation;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperation;
import core.basesyntax.strategy.operation.ReturnOperation;
import core.basesyntax.strategy.operation.SupplyOperation;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final File REPORT = new File("src/main/resources/report.csv");
    private static final File FINAL_REPORT = new File("src/main/resources/final-report.csv");

    public static void main(String[] args) {
        FileReaderService fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.getDataFromFile(REPORT);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransactions(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String finalReport = reportGenerator.getReport();

        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.write(finalReport, FINAL_REPORT);
    }
}
