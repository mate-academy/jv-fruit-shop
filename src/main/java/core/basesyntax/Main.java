package core.basesyntax;

import core.basesyntax.impl.FileReadServiceImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.impl.TransactionParserImpl;
import core.basesyntax.impl.WriteServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FileReadService;
import core.basesyntax.services.ReportService;
import core.basesyntax.services.TransactionParser;
import core.basesyntax.services.WriteService;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/initial";
    private static final String REPORT_FILE_PATH = "src/main/resources/report";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap
                .put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());

        FileReadService fileReader = new FileReadServiceImpl();
        List<String> dataFromFile = fileReader.readFromFile(INPUT_FILE_PATH);
        TransactionParser parser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactionsList
                = parser.parse(dataFromFile);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        for (FruitTransaction fruitTransaction : fruitTransactionsList) {
            OperationHandler handler = operationStrategy
                    .getOperation(fruitTransaction.getOperation());
            handler.perfomOperation(fruitTransaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(report, REPORT_FILE_PATH);
    }
}
