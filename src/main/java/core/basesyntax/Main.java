package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataConverterImpl;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileReaderServiceImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
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

public class Main {
    public static void main(String[] args) {
        FileReaderService fileReader = new FileReaderServiceImpl();
        List<String> inputReport = fileReader.read("fruit_shop_input.csv");
        DataConverter dataConverter = new DataConverterImpl();
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperation());
        operationHandlers.put(Operation.RETURN, new ReturnOperation());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperation());
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(strategy);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        shopService.proces(transactions);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report);
    }
}
