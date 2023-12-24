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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String INPUT_FILE_PATH = "jv-fruit-shop/src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "jv-fruit-shop/src/main/resources/report.csv";
    private static final String BALANCE_OPERATION_CODE = "b";
    private static final String PURCHASE_OPERATION_CODE = "p";
    private static final String SUPPLY_OPERATION_CODE = "s";
    private static final String RETURN_OPERATION_CODE = "r";
    private static final Map<String, OperationHandler> operationHandlerMap = new HashMap<>();

    public static void main(String[] args) {
        operationHandlerMap.put(BALANCE_OPERATION_CODE, new BalanceHandler());
        operationHandlerMap.put(PURCHASE_OPERATION_CODE, new PurchaseHandler());
        operationHandlerMap.put(RETURN_OPERATION_CODE, new AddFruitQuantity());
        operationHandlerMap.put(SUPPLY_OPERATION_CODE, new AddFruitQuantity());

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
