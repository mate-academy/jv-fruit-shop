package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
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
        ReaderService readerService = new ReaderServiceImpl();
        List<String> lines = readerService.readFile(INPUT);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        List<FruitTransaction> fruitTransactions = new ParserServiceImpl().parseTransactions(lines);
        OperationStrategy strategy = new OperationStrategy(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl();
        fruitService.processTransactions(fruitTransactions, strategy);
        WriterService writeService = new WriteServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        writeService.writeToFile(REPORT, report);
    }
}
