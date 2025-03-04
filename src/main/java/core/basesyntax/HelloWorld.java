package core.basesyntax;

import core.basesyntax.dao.DataConverter;
import core.basesyntax.dao.DataConverterImpl;
import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileReaderImpl;
import core.basesyntax.dao.FileWriter;
import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    public static class Main {
        public static void main(String[] arg) {
            FileReader fileReader = new FileReaderImpl();
            List<String> inputReport = fileReader.read("reportToRead.csv");

            Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
            operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
            operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
            operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
            operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());

            OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
            DataConverter dataConverter = new DataConverterImpl();

            List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
            ShopService shopService = new ShopServiceImpl(operationStrategy);
            shopService.process(transactions);

            ReportGenerator reportGenerator = new ReportGeneratorImpl();
            String resultingReport = reportGenerator.getReport(shopService.getInventory());

            FileWriter fileWriter = new FileWriterImpl();
            fileWriter.write(resultingReport, "finalReport.csv");
        }
    }
}
