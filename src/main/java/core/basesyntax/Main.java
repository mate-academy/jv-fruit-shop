package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FileReadService;
import core.basesyntax.services.FileWriteService;
import core.basesyntax.services.ReportService;
import core.basesyntax.services.impl.FileReadServiceImpl;
import core.basesyntax.services.impl.FileWriteServiceImpl;
import core.basesyntax.services.impl.FruitTransactionServiceImpl;
import core.basesyntax.services.impl.ReportServiceImpl;
import core.basesyntax.services.strategy.OperationHandler;
import core.basesyntax.services.strategy.OperationStrategy;
import core.basesyntax.services.strategy.impl.BalanceHandlerOperation;
import core.basesyntax.services.strategy.impl.OperationStrategyImpl;
import core.basesyntax.services.strategy.impl.PurchaseHandlerOperation;
import core.basesyntax.services.strategy.impl.ReturnHandlerOperation;
import core.basesyntax.services.strategy.impl.SupplyHandlerOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "scr/main/resources/dataInput.csv";
    private static final String OUTPUT_FILE_PATH = "scr/main/resources/dataOutput.csv";

    public static void main(String[] args) {
        FileReadService fileReadService = new FileReadServiceImpl();
        List<String> dataFile = fileReadService.readDataFromFile(INPUT_FILE_PATH);

        Map<FruitTransaction.Type, OperationHandler> typeOperationHandlerMap = new HashMap<>();
        typeOperationHandlerMap.put(FruitTransaction.Type.BALANCE, new BalanceHandlerOperation());
        typeOperationHandlerMap.put(FruitTransaction.Type.SUPPLY, new SupplyHandlerOperation());
        typeOperationHandlerMap.put(FruitTransaction.Type.PURCHASE, new PurchaseHandlerOperation());
        typeOperationHandlerMap.put(FruitTransaction.Type.RETURN, new ReturnHandlerOperation());

        FruitTransactionServiceImpl service = new FruitTransactionServiceImpl();
        List<FruitTransaction> fruitTransactionsToList = service.transaction(dataFile);

        OperationStrategy operationStrategy = new OperationStrategyImpl(typeOperationHandlerMap);

        for (FruitTransaction fruitTransaction : fruitTransactionsToList) {
            OperationHandler handler = operationStrategy.get(fruitTransaction.getType());
            handler.operation(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImpl();
        String fileReport = reportService.createReport();

        FileWriteService fileWriteService = new FileWriteServiceImpl();
        fileWriteService.writeDataToFile(fileReport, OUTPUT_FILE_PATH);
        System.out.println(fileReadService.readDataFromFile(OUTPUT_FILE_PATH));
    }
}
