package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreatingReport;
import core.basesyntax.service.FileReadingService;
import core.basesyntax.service.FileWritingService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ProcessingData;
import core.basesyntax.service.impl.CreatingReportImpl;
import core.basesyntax.service.impl.FileReadingServiceImpl;
import core.basesyntax.service.impl.FileWritingServiceImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ProcessingDataImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.Purchase;
import core.basesyntax.strategy.impl.ReturnFruit;
import core.basesyntax.strategy.impl.Supply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String OPERATIONS_PATH = "src/main/resources/dailyTransactions.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap
                = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new Purchase());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnFruit());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new Supply());

        FileReadingService fileReader = new FileReadingServiceImpl();
        List<String> dataFromDailyReport = fileReader.readFile(OPERATIONS_PATH);

        ProcessingData processData = new ProcessingDataImpl();
        List<FruitTransaction> fruitTransactions = processData.parseData(dataFromDailyReport);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        fruitTransactions.forEach(t -> operationStrategy
                .get(t.getOperation())
                .makeOperation(t));

        CreatingReport creatingReport = new CreatingReportImpl();
        String report = creatingReport.createReport();

        FileWritingService fileWriter = new FileWritingServiceImpl();
        fileWriter.writeFile(REPORT_PATH, report);
    }
}
