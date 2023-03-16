package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataProcessorService;
import core.basesyntax.service.DataReaderService;
import core.basesyntax.service.DataWriterService;
import core.basesyntax.service.StrategyApplicationService;
import core.basesyntax.service.impl.DataProcessorServiceImpl;
import core.basesyntax.service.impl.DataReaderServiceImpl;
import core.basesyntax.service.impl.DataWriterServiceImpl;
import core.basesyntax.service.impl.StrategyApplicationServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handlers.BalanceOperationHandler;
import core.basesyntax.strategy.handlers.PurchaseOperationHandler;
import core.basesyntax.strategy.handlers.ReturnOperationHandler;
import core.basesyntax.strategy.handlers.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_TO_READ =
            "src/main/resources/input.csv";
    private static final String FILE_PATH_TO_WRITE =
            "src/main/resources/report.csv";

    public static void main(String[] args) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler()
        ));

        DataReaderService readDataFromFile = new DataReaderServiceImpl();
        final List<String> readData = readDataFromFile.readData(FILE_PATH_TO_READ);

        DataProcessorService processDataFromFile = new DataProcessorServiceImpl();
        final List<String[]> processData = processDataFromFile.processData(readData);

        StrategyApplicationService strategyApplicationService =
                new StrategyApplicationServiceImpl(operationStrategy);
        strategyApplicationService.applyOperationStrategy(processData);

        DataWriterService writeReportToFile = new DataWriterServiceImpl();
        writeReportToFile.writeData(Storage.fruits, FILE_PATH_TO_WRITE);
    }
}
