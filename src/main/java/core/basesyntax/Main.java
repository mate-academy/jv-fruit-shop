package core.basesyntax;

import core.basesyntax.operation.BalanceOperation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperation;
import core.basesyntax.operation.ReturnOperation;
import core.basesyntax.operation.SupplyOperation;
import core.basesyntax.service.DataConverterImpl;
import core.basesyntax.service.DataConverterMethods;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileReaderMethods;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.FileWriterMethods;
import core.basesyntax.service.ReportGenerationImpl;
import core.basesyntax.service.ReportGenerationMethods;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "fruits.csv";
    private static final String OUTPUT_FILE = "src/main/resources/result.csv";

    public static void main(String[] args) {
        FileReaderMethods fileReader = new FileReaderImpl();
        List<String> readFruits = fileReader.readFile(INPUT_FILE);

        DataConverterMethods dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(readFruits);

        Map<FruitTransaction.Operation, OperationHandler> operationHandler = new HashMap<>();
        operationHandler.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandler.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandler.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandler.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandler);

        Storage storage = new Storage();

        ShopService shopService = new ShopServiceImpl(operationStrategy, storage.getStorage());
        shopService.process(transactions);

        ReportGenerationMethods reportGeneration = new ReportGenerationImpl();
        String resultingReport = reportGeneration.reportGeneration(storage.getStorage());

        FileWriterMethods fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(OUTPUT_FILE, resultingReport);
    }
}
