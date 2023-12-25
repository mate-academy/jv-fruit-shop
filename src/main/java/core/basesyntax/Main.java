package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.db.InputFileHandlerImpl;
import core.basesyntax.db.InputFileReaderImpl;
import core.basesyntax.db.ReportFileWriter;
import core.basesyntax.db.ReportFileWriterImpl;
import core.basesyntax.handlers.AddFruitQuantity;
import core.basesyntax.handlers.BalanceHandler;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String INPUT_FILE_PATH = "jv-fruit-shop/src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "jv-fruit-shop/src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = Map.of(
                OperationStrategyImpl.Operation.BALANCE.getOperationCode(), new BalanceHandler(),
                OperationStrategyImpl.Operation.PURCHASE.getOperationCode(), new PurchaseHandler(),
                OperationStrategyImpl.Operation.RETURN.getOperationCode(), new AddFruitQuantity(),
                OperationStrategyImpl.Operation.SUPPLY.getOperationCode(), new AddFruitQuantity());

        InputFileReaderImpl storageFileReader = new InputFileReaderImpl();
        Scanner scanner = storageFileReader.readFromFile(INPUT_FILE_PATH);

        InputFileHandlerImpl inputFileHandler = new InputFileHandlerImpl();
        List<String> inputList = inputFileHandler.inputData(scanner);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        operationStrategy.operationPerform(inputList);

        ReportFileWriter writer = new ReportFileWriterImpl();
        writer.writeToFile(FruitStorage.storageData, REPORT_FILE_PATH);
    }
}
