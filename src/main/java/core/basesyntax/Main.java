package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ProcessDataServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_FROM = "src/main/resources/input.csv";
    private static final String FILE_PATH_TO = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        handlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        handlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        handlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        List<String> inputData = new ReaderServiceImpl().readFromFile(FILE_PATH_FROM);
        List<Transaction> transactions = new ParserServiceImpl().parseLines(inputData);
        OperationStrategy strategy = new OperationStrategyImpl(handlerMap);
        new ProcessDataServiceImpl().processData(transactions, handlerMap, strategy);
        String report = new ReportServiceImpl().createReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, FILE_PATH_TO);
    }
}
