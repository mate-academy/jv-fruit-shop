package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.operation.BalanceOperation;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperation;
import core.basesyntax.strategy.operation.ReturnOperation;
import core.basesyntax.strategy.operation.SupplyOperation;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_DATA_PATH = "src/main/resources/input-data.csv";
    public static final String OUTPUT_DATA_PATH = "src/main/resources/final-report.csv";

    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReader();
        List<String> inputReport = fileReader.read(INPUT_DATA_PATH);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new CsvDataConverter();
        List<FruitTransaction> transactions = dataConverter
                .convertToTransaction(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.generateReport(Storage.fruitStorage);

        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.writeReport(resultingReport, OUTPUT_DATA_PATH);
    }
}
