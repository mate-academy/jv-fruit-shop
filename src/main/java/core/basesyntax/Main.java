package core.basesyntax;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.impl.BalanceOperation;
import core.basesyntax.handler.impl.PurchaseOperation;
import core.basesyntax.handler.impl.ReturnOperation;
import core.basesyntax.handler.impl.SupplyOperation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.util.FileReader;
import core.basesyntax.util.FileWriter;
import core.basesyntax.util.impl.FileReaderImpl;
import core.basesyntax.util.impl.FileWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "reportToRead.csv";
    private static final String OUTPUT_FILE_PATH = "finalReport.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(INPUT_FILE_PATH);

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<String, Integer> fruitStorage = new HashMap<>();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperation(fruitStorage),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(fruitStorage),
                FruitTransaction.Operation.RETURN, new ReturnOperation(fruitStorage),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation(fruitStorage)
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(fruitStorage);
        String resultingReport = reportGenerator.createReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, OUTPUT_FILE_PATH);
    }
}
