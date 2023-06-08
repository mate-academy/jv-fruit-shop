package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.GreatReportService;
import core.basesyntax.service.IsDataFromInputFileCorrect;
import core.basesyntax.service.ReadDataFromFile;
import core.basesyntax.service.WriteDataToFile;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.GreatReportServiceImpl;
import core.basesyntax.service.impl.IsDataFromInputFileCorrectImpl;
import core.basesyntax.service.impl.ReadDataFromFileImpl;
import core.basesyntax.service.impl.WriteDataToFileImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.impl.OperationBalanceHandler;
import core.basesyntax.service.operation.impl.OperationPurchaseHandler;
import core.basesyntax.service.operation.impl.OperationReturnHandler;
import core.basesyntax.service.operation.impl.OperationSupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH
            = "src/main/java/core/basesyntax/resuorse/statisticDataFile.csv";
    private static final String STATISTIC_FILE_PATH
            = "src/main/java/core/basesyntax/resuorse/reportDataFile.csv";

    public static void main(String[] args) {
        ReadDataFromFile reader = new ReadDataFromFileImpl();
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new OperationBalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new OperationPurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new OperationReturnHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new OperationSupplyHandler());
        List<String> dataFromFile = reader.readStatisticFromFile(INPUT_FILE_PATH);
        IsDataFromInputFileCorrect isDataChecker = new IsDataFromInputFileCorrectImpl();
        if (isDataChecker.isDataFromInputFileCorrect(dataFromFile)) {
            fruitTransactionService.greatFruitTransaction(dataFromFile, operationHandlerMap);
        }
        GreatReportService greatReport = new GreatReportServiceImpl();
        String stringReport = greatReport.generateReport(Storage.getDb());
        WriteDataToFile writer = new WriteDataToFileImpl();
        writer.writeReportToFile(STATISTIC_FILE_PATH, stringReport);
    }
}
