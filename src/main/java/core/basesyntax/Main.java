package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.ConvertServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT = "src/main/java/resources/input file.csv";
    private static final String REPORT = "src/main/java/resources/report file.csv";

    public static void main(String[] args) {
        List<String> fromFile = new ReaderServiceImpl()
                .readFile(INPUT);
        List<FruitTransaction> fruitTransactions = new ConvertServiceImpl()
                .parseTransactions(fromFile);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        OperationStrategy strategy = new OperationStrategy(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl();
        fruitService.processTransactions(fruitTransactions, strategy);
        new WriteServiceImpl().writeToFile(REPORT, new ReportServiceImpl().createReportService());
    }
}
