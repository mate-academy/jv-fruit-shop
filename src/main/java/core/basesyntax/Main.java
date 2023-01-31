package core.basesyntax;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.*.;
import core.basesyntax.service.impl.*.;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputFilePath = "src/main/resources/testFile.csv";
    private static final String reportFilePath = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> strategies = new HashMap<>();
        strategies.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        strategies.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        strategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        strategies.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFromFile(inputFilePath);

        FruitTransactionParser parser = new FruitTransactionParserImpl();
        List<FruitTransaction> fruitTransactionsList
                = parser.getFruitTransactionsList(dataFromFile);

        OperationStrategy operationStrategy = new OperationStrategyImpl(strategies);

        for (FruitTransaction fruitTransaction : fruitTransactionsList) {
            OperationHandler handler = operationStrategy
                    .get(fruitTransaction.getOperation());
            handler.operate(fruitTransaction);
        }

        ReportMaker reportMaker = new ReportMakerImpl();
        String report = reportMaker.createReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, reportFilePath);
    }
}
