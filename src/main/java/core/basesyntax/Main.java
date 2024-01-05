package core.basesyntax;

import core.basesyntax.impl.ParserServiceImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.WriterServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.operationhandler.BalanceHandler;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.service.operationhandler.PurchaseHandler;
import core.basesyntax.service.operationhandler.ReturnHandler;
import core.basesyntax.service.operationhandler.SupplyHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_NAME = "src/main/resources/input.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";
    private static final Map<Operation, OperationHandler> operationHandlerMap = Map.of(
            Operation.BALANCE, new BalanceHandler(),
            Operation.PURCHASE, new PurchaseHandler(),
            Operation.RETURN, new ReturnHandler(),
            Operation.SUPPLY, new SupplyHandler()
    );

    public static void main(String[] args) {
        ReaderServiceImpl fileReader = new ReaderServiceImpl();
        ParserServiceImpl transactionParser = new ParserServiceImpl();
        List<String> lines = fileReader.readData(FILE_NAME);
        List<FruitTransaction> transactions = transactionParser.parseTransactions(lines);
        OperationStrategy operationStrategy = new OperationStrategy(operationHandlerMap);
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy
                    .getHandler(transaction.getOperation());
            operationHandler.handleOperation(transaction);
        }
        ReportService reportCreator = new ReportService();
        WriterServiceImpl fileWriter = new WriterServiceImpl();
        fileWriter.writeToFile(reportCreator.generateReport(), REPORT_FILE_NAME);
    }
}
