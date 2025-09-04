package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            FileReaderService fileReader = new FileReaderServiceImpl();
            List<String> inputReport = fileReader.read("reportToRead.csv");

            DataConverter dataConverter = new DataConverterImpl();
            List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

            Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
            operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
            operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
            operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
            operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
            OperationStrategyImpl operationStrategy = new OperationStrategyImpl(operationHandlers);

            ShopService shopService = new ShopServiceImpl(operationStrategy);
            shopService.process(transactions);

            ReportGenerator reportGenerator = new ReportGeneratorImpl();
            String resultingReport = reportGenerator.getReport();

            FileWriterService fileWriter = new FileWriterServiceImpl();
            fileWriter.write(resultingReport, "finalReport.csv");

        } catch (Exception e) {
            System.err.println("Error processing fruit transactions: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
