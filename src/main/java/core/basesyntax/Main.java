package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserInFruitTransactionImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/listAllOperation.csv";
    private static final String PATH_TO_REPORT = "src/main/resources/countProduct.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationsMap = new HashMap<>();
        operationsMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationsMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationsMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationsMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        ReaderService readService = new ReadServiceImpl();
        ParserService parser = new ParserInFruitTransactionImpl();
        OperationStrategy fruitStrategy =
                new OperationStrategyImpl(operationsMap);
        FruitService fruitService = new FruitServiceImpl(fruitStrategy);
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> strings = readService.readFromFile(PATH_TO_INPUT_FILE);
        List<FruitTransaction> fruitTransactions = parser.parseData(strings);

        fruitService.processTransactions(fruitTransactions);
        writerService.write(PATH_TO_REPORT,reportService.reportStorage());
    }
}
