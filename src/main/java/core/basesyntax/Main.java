package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReport;
import core.basesyntax.service.DataProcessing;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CreateReportImpl;
import core.basesyntax.service.impl.DataProcessingImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseHandler;
import core.basesyntax.strategy.operation.ReturnHandler;
import core.basesyntax.strategy.operation.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String FROM_FILE = "src/main/resources/file.csv";
    public static final String TO_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        FruitDao fruitDao = new FruitDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler(fruitDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        DataProcessing dataProcessing = new DataProcessingImpl(operationStrategy);

        List<String> data = readerService.readFromFile(FROM_FILE);
        List<FruitTransaction> transactions = dataProcessing.convertDataIntoTransaction(data);

        for (FruitTransaction transaction : transactions) {
            operationStrategy.getHandler(transaction.getOperation()).handle(transaction);
        }

        CreateReport createReport = new CreateReportImpl();
        String report = createReport.createReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(TO_FILE, report);
    }
}
