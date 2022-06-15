package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.Balance;
import core.basesyntax.strategy.impl.Purchase;
import core.basesyntax.strategy.impl.ReturnFruit;
import core.basesyntax.strategy.impl.Supply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String OPERATIONS_PATH = "src/main/java/operations.csv";
    private static final String REPORT_PATH = "src/main/java/report.csv";

    public static void main(String[] args) {
        final Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap = new HashMap<>();
        operationOperationHandlerMap.put(FruitTransaction.Operation.BALANCE, new Balance());
        operationOperationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new Purchase());
        operationOperationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnFruit());
        operationOperationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new Supply());

        FileHandler fileHandler = new FileHandlerImpl();
        ProcessingDataFromFile processData = new ProcessingDataFromFileImpl();
        GenerationDataForStorage generateData =
                new GenerationDataForStorageImpl(
                        new OperationStrategyImpl(operationOperationHandlerMap));
        CreatingReport creatingReport = new CreatingReportImpl();

        List<String> dataFromDailyReport = fileHandler.readFile(OPERATIONS_PATH);

        List<FruitTransaction> fruitTransactions = processData.processData(dataFromDailyReport);

        generateData.generateData(fruitTransactions);

        String report = creatingReport.createReport();

        fileHandler.writeFile(REPORT_PATH, report);
    }
}
