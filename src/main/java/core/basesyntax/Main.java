package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.impl.handlers.BalanceOperationHandlerImpl;
import core.basesyntax.service.impl.handlers.PurchaseOperationHandlerImpl;
import core.basesyntax.service.impl.handlers.ReturnOperationHandlerImpl;
import core.basesyntax.service.impl.handlers.SupplyOperationHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputCsvPath = "src/main/resources/input.csv";
    private static final String reportCsvPath = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromInputCsv = readerService.readFromFile(inputCsvPath);
        FruitTransactionParser parser = new FruitTransactionParserImpl();
        Map<FruitTransaction.Operation, OperationHandler> strategies = new HashMap<>();
        strategies.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandlerImpl());
        List<FruitTransaction> fruitTransactionsList
                = parser.getFruitTransactionsList(dataFromInputCsv);
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategies);
        for (FruitTransaction fruitTransaction : fruitTransactionsList) {
            OperationHandler handler = operationStrategy
                    .getHandler(fruitTransaction.getOperation());
            handler.operate(fruitTransaction);
        }
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, reportCsvPath);
    }
}
