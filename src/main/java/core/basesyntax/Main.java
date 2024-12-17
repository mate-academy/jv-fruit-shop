package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataConverterImpl;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandlerStrategy;
import core.basesyntax.strategy.OperationHandlerStrategyImpl;
import core.basesyntax.strategy.handlers.BalanceOperation;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.PurchaseOperation;
import core.basesyntax.strategy.handlers.ReturnOperation;
import core.basesyntax.strategy.handlers.SupplyOperation;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Path INPUT_FILE = Paths.get("src/main/resources/input.csv");
    public static final Path OUTPUT_FILE = Paths.get("src/main/resources/output.csv");

    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        List<String> inputRecords = reader.read(INPUT_FILE);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());

        DataConverter converter = new DataConverterImpl();
        List<FruitTransaction> fruitTransactions = converter.convertToTransaction(inputRecords);

        OperationHandlerStrategy operationHandlerStrategy =
                new OperationHandlerStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationHandlerStrategy);
        shopService.process(fruitTransactions);

        ReportGenerator generator = new ReportGeneratorImpl();
        String report = generator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, OUTPUT_FILE);
    }
}
