package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.BalanceOperation;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.PurchaseOperation;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ReturnOperation;
import core.basesyntax.service.impl.SupplyOperation;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT = "src/main/resources/input_file.csv";
    private static final String REPORT = "src/main/resources/report_file.csv";

    public static void main(String[] args) {
        List<String> lines = new ReaderServiceImpl()
                .readFile(INPUT);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        List<FruitTransaction> fruitTransactions = new ParserServiceImpl().parseTransactions(lines);
        OperationStrategy strategy = new OperationStrategy(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl();
        fruitService.processTransactions(fruitTransactions, strategy);
        WriterService writeService = new WriteServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        writeService.writeToFile(REPORT, reportService.createReport());
    }
}
