package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.db.InputFileHandlerImpl;
import core.basesyntax.db.ReportFileWriter;
import core.basesyntax.db.ReportFileWriterImpl;
import core.basesyntax.handlers.BalanceHandler;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseHandler;
import core.basesyntax.handlers.QuantityAdditionHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = Map.of(
                OperationStrategyImpl.Operation.BALANCE.getOperationCode(), new BalanceHandler(),
                OperationStrategyImpl.Operation.PURCHASE.getOperationCode(), new PurchaseHandler(),
                OperationStrategyImpl.Operation.RETURN.getOperationCode(),
                new QuantityAdditionHandler(),
                OperationStrategyImpl.Operation.SUPPLY.getOperationCode(),
                new QuantityAdditionHandler());

        InputFileHandlerImpl inputFileHandler = new InputFileHandlerImpl();
        List<String> inputList = inputFileHandler.inputData(INPUT_FILE_PATH);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        operationStrategy.operationPerform(inputList);

        ReportFileWriter writer = new ReportFileWriterImpl();
        writer.writeToFile(FruitStorage.storageData, REPORT_FILE_PATH);
    }
}
