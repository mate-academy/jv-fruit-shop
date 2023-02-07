package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/dataInput.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/dataReport.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler()
        );

        List<String> inputData = new ReaderServiceImpl().readFromFile(INPUT_FILE_NAME);
        List<FruitTransaction> fruitTransactionList = new ParseServiceImpl().parse(inputData);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationStrategyMap);
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler operationHandler = operationStrategy
                    .getOperation(fruitTransaction.getOperation());
            operationHandler.apply(fruitTransaction);
        }
        String report = new ReportServiceImpl().createReport();
        new WriterServiceImpl().writeToFile(report, REPORT_FILE_NAME);
    }
}
