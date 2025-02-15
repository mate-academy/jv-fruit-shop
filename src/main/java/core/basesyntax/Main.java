package core.basesyntax;

import core.basesyntax.operation.*;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "fruits.csv";
    private static final String OUTPUT_FILE = "target/result.csv";

    public static void main(String[] args) {
        FileReaderMet fileReader = new FileReaderImpl();
        List<String> readFruits = fileReader.readFile(INPUT_FILE);

        DataConverterMet dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(readFruits);

        Map<FruitTransaction.Operation, OperationHandler> operationHandler = new HashMap<>();
        operationHandler.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandler.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandler.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandler.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandler);

        Map<String, Integer> storage = new HashMap<>();
        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);
        shopService.process(transactions);

        ReportGenerationMet reportGeneration = new ReportGenerationImpl();
        String resultingReport = reportGeneration.reportGeneration(storage);

        FileWriterMet fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(OUTPUT_FILE, resultingReport);
    }
}
