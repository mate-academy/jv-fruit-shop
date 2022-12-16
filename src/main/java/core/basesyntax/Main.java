package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.OperationHandler;
import core.basesyntax.services.OperationStrategy;
import core.basesyntax.services.ReaderService;
import core.basesyntax.services.ReportMaker;
import core.basesyntax.services.WriterService;
import core.basesyntax.services.impl.FruitTransactionParserImpl;
import core.basesyntax.services.impl.OperationStrategyImpl;
import core.basesyntax.services.impl.ReaderServiceImpl;
import core.basesyntax.services.impl.ReportMakerImpl;
import core.basesyntax.services.impl.WriterServiceImpl;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/dataInput.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/dataReport.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dateFromFile = readerService.readFile(INPUT_FILE_PATH);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlersMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlersMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlersMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        FruitTransactionParserImpl parser = new FruitTransactionParserImpl();
        List<FruitTransaction> fruitTransactionsList =
                parser.getFruitTransactionsList(dateFromFile);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);

        for (FruitTransaction fruitTransaction : fruitTransactionsList) {
            OperationHandler handler = operationStrategy
                    .get(fruitTransaction.getOperation());
            handler.operate(fruitTransaction);
        }

        ReportMaker reportMaker = new ReportMakerImpl();
        String report = reportMaker.makeReport();

        WriterService fileWriterService = new WriterServiceImpl();
        fileWriterService.writeToFile(report, REPORT_FILE_PATH);
        System.out.println(readerService.readFile(REPORT_FILE_PATH));
    }
}
