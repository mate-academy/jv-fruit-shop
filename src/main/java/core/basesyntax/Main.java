package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE
            = "src/main/resources/input_file.csv";
    private static final String REPORT_FILE
            = "src/main/resources/report_file.csv";

    public static void main(String[] args) {
        final List<String> linesFromFile = new ReaderServiceImpl().readFromFile(INPUT_FILE);
        final List<FruitTransaction> fruitTransactions =
                new TransactionServiceImpl().parseTransactions(linesFromFile);
        final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap
                = new HashMap<>();
        final OperationStrategy strategy = new OperationStrategy(operationHandlerMap);
        final FruitService fruitService = new FruitServiceImpl();
        fruitService.processTransactions(fruitTransactions, strategy);
        new WriterServiceImpl().writeToFile(REPORT_FILE, new ReportServiceImpl().createReport());
    }
}
