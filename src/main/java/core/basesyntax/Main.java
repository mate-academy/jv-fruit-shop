package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
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
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputData = fileReader.read(INPUT_PATH);

        DataConverter dataConverter = new DataConverterImpl();

        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperation());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(Operation.RETURN, new ReturnOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);

        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputData);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, OUTPUT_PATH);
    }
}
