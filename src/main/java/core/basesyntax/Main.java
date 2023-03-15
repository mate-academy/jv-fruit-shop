package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationHandlerStrategy;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationStrategies = new HashMap<>();
        operationStrategies.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationStrategies.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationStrategies.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationStrategies.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        ReaderService readerService = new ReaderServiceImpl();
        ParserService fruitTransactionParser = new ParserServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> records = readerService.read(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = fruitTransactionParser.parse(records);

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandlerStrategy operationHandlerStrategy
                    = new OperationHandlerStrategy(operationStrategies);
            OperationHandler handler = operationHandlerStrategy.get(fruitTransaction);
            handler.handle(fruitTransaction);
        }

        String report = reportService.createReport();
        writerService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
