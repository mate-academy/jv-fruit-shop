package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.ReadData;
import core.basesyntax.service.WriteData;
import core.basesyntax.service.impl.CreateReportImpl;
import core.basesyntax.service.impl.ParseFruitsImpl;
import core.basesyntax.service.impl.ReadDataImpl;
import core.basesyntax.service.impl.WriteDataImpl;
import core.basesyntax.service.strategy.BalanceHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.service.strategy.PurchaseHandler;
import core.basesyntax.service.strategy.ReturnHandler;
import core.basesyntax.service.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    private static final String FILE_PATH = "src/main/java/core/basesyntax/resourse/report.cvs";
    private static final String INPUT = "src/main/java/core/basesyntax/resourse/fruitsInfo.csv";

    public static void main(String[] args) {
        ReadData readData = new ReadDataImpl();
        List<String> dataFromFile = readData.read(INPUT);
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnHandler());

        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);

        List<FruitTransaction> transactionsList = new ParseFruitsImpl().transactions(dataFromFile);
        for (FruitTransaction fruitTransactions : transactionsList) {
            OperationHandler operationHandler = strategy.get(fruitTransactions.getOperation());
            operationHandler.apply(fruitTransactions);
        }

        String report = new CreateReportImpl().getReport();
        WriteData writeData = new WriteDataImpl();
        writeData.writeToFile(report,FILE_PATH);

    }
}
