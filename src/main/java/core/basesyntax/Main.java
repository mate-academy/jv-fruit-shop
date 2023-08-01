package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConvertingToObjectsService;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.impl.CsvDataConvertingToObjectsService;
import core.basesyntax.service.impl.CsvDataProcessingService;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.io.File;
import java.util.Map;

public class Main {
    private static final Map<Operation, OperationHandler> operationHandlerMap = Map.of(
            Operation.BALANCE, new BalanceOperationHandler(),
            Operation.SUPPLY, new SupplyOperationHandler(),
            Operation.PURCHASE, new PurchaseOperationHandler(),
            Operation.RETURN, new ReturnOperationHandler());

    public static void main(String[] args) {
        File file = new File("src/main/resources/input.csv");
        FileReaderService fileReaderService = new CsvFileReaderService(file);
        DataConvertingToObjectsService dataConverting = new CsvDataConvertingToObjectsService(fileReaderService);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        DataProcessingService dataProcessingService = new CsvDataProcessingService(operationStrategy,
                                                                                    dataConverting);
        dataProcessingService.importDataToStorage();
        System.out.println(Storage.storage);
    }
}
